package com.demo.common.security.provider.authentication;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * Created by HoYoung on 2023/03/08.
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class AuthenticationProcessingFilter extends OncePerRequestFilter {

    private final BearerTokenExtractor bearerTokenExtractor;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {

//        log.debug(">>>>>> {}", this.getClass().getName());

        Authentication authentication = this.bearerTokenExtractor.extract(request);

        if(authentication == null) {
            SecurityContextHolder.clearContext();
        } else {
            if (authentication instanceof AbstractAuthenticationToken needsDetails) {
                needsDetails.setDetails(new HttpServletRequestWrapper(request));
            }

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);

    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return super.shouldNotFilter(request);
    }

}
