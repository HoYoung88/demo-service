package com.demo.common.security.provider.authentication;

import jakarta.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Created by HoYoung on 2023/03/08.
 */
@Component
public class BearerTokenExtractor {
    private static final Pattern authorizationPattern = Pattern.compile(
            "^Bearer (?<token>[a-zA-Z0-9-._~+/]+=*)$",
            Pattern.CASE_INSENSITIVE);

    public Authentication extract(HttpServletRequest request) {
        String tokenValue = extractToken(request);
        if (tokenValue != null) {
            return new PreAuthenticatedAuthenticationToken(tokenValue, "");
        }
        return null;
    }

    protected String extractToken(HttpServletRequest request) {
        String token = extractHeaderToken(request);

        if (token == null) {

        }

        return token;
    }

    protected String extractHeaderToken(HttpServletRequest request) {
        String authorization = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (!StringUtils.startsWithIgnoreCase(authorization, "bearer")) {
            return null;
        }

        Matcher matcher = authorizationPattern.matcher(authorization);
        if (!matcher.matches()) {
//            throw new AuthenticationServiceException(USER_AUTHORIZED_EXPIRED.toString());
        }
        return matcher.group("token");

    }
}
