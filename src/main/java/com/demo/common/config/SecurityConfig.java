package com.demo.common.config;

import com.demo.common.security.auth.CustomAuthenticationEntryPoint;
import com.demo.common.security.provider.authentication.AuthenticationProcessingFilter;
import com.demo.common.security.handler.CustomAccessDeniedHandler;
import com.demo.common.security.provider.UsernamePasswordAuthentication;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created by HoYoung on 2023/03/08.
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@Slf4j
public class SecurityConfig {

    private final CustomAccessDeniedHandler customAccessDeniedHandler;
    private final CustomAuthenticationEntryPoint customAuthenticationEntryPoint;
    private final AuthenticationProcessingFilter authenticationProcessingFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    protected WebSecurityCustomizer webSecurityCustomizer() {
        // 정적 자원에 대해서 Security를 적용하지 않음으로 설정
        return web -> web.ignoring()
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }

    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .cors().disable()
                .formLogin()
                .permitAll()
                .and()
//                .formLogin().disable()
                .httpBasic().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeHttpRequests(authz -> authz.anyRequest().permitAll())
//                .authorizeHttpRequests(authz -> authz.anyRequest().hasRole("ROLE_ADMIN"))
                .exceptionHandling()
                    .accessDeniedHandler(this.customAccessDeniedHandler)
                    .authenticationEntryPoint(this.customAuthenticationEntryPoint)
                .and()
                .addFilterBefore(this.authenticationProcessingFilter, UsernamePasswordAuthenticationFilter.class);
//                .addFilterBefore(jwtAuthorizationFilter(), BasicAuthenticationFilter.class)
//                .addFilterBefore(customAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
        ;
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            UsernamePasswordAuthentication usernamePasswordAuthentication) {
        return new ProviderManager(usernamePasswordAuthentication);
    }
}
