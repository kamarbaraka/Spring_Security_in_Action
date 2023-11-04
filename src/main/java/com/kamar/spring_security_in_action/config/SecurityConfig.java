package com.kamar.spring_security_in_action.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

/**
 * the security configuration.
 * @author kamar baraka.*/

@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{

        /*enable http Basic authentication*/
        httpSecurity.httpBasic(customizer -> {});
        /*enable login form*/
        httpSecurity.formLogin(formLogin -> {});

        /*disable csrf*/
        httpSecurity.csrf(AbstractHttpConfigurer::disable);
        /*build and return*/
        return httpSecurity.build();
    }
}
