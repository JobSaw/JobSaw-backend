package com.jobsaw.jobsaw.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * Configures the Spring Security filter chain.
     * Allows public access to the root path and index.html, and requires authentication for everything else.
     * Enables OAuth2 Login for Google authentication.
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            // Authorize requests for public static resources
            .authorizeHttpRequests(authz -> authz
                .requestMatchers("/", "/index.html", "/error").permitAll()
                .anyRequest().authenticated()
            )
            // Enable OAuth2 login and redirect to the index page on success
            .oauth2Login(oauth2 -> oauth2
                .defaultSuccessUrl("/index.html", true)
            );
        
        return http.build();
    }
}
