package com.kamar.spring_security_in_action.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * the security configuration.
 * @author kamar baraka.*/

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{

        /*all methode access without authorization*/
        httpSecurity.authorizeHttpRequests(customizer ->
                customizer.anyRequest().authenticated());

        /*enable http Basic authentication*/
        httpSecurity.httpBasic(customizer -> {});

        /*build and return*/
        return httpSecurity.build();
    }
}
