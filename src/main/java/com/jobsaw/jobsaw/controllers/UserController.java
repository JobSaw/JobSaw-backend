package com.jobsaw.jobsaw.controllers;

import com.jobsaw.jobsaw.logging.Loggable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {



    /**
     * Endpoint to fetch the authenticated user's details.
     * Injects the OAuth2User details populated by Spring Security upon successful login.
     *
     * @param principal the authenticated OAuth2 user
     * @return a map containing user attributes, or an empty map if unauthenticated.
     */
    @GetMapping("/user")
    @Loggable("Fetch Authenticated User Info")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        if (principal == null) {
            return Collections.emptyMap();
        }
        
        return principal.getAttributes();
    }
}
