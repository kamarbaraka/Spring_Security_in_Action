package com.kamar.spring_security_in_action.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * the security configuration.
 * @author kamar baraka.*/

@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity,
                                                   AuthenticationEntryPoint authenticationEntryPoint,
                                                   AuthenticationSuccessHandler successHandler,
                                                   AuthenticationFailureHandler failureHandler) throws Exception{

        /*enable http Basic authentication*/
        httpSecurity.httpBasic(httpBasic -> {
            httpBasic.realmName("S.S.I.A");
            httpBasic.authenticationEntryPoint(authenticationEntryPoint);
        });
        /*enable login form*/
        httpSecurity.formLogin(formLogin -> {

            formLogin.successHandler(successHandler);
            formLogin.failureHandler(failureHandler);
        });

        /*disable csrf*/
        httpSecurity.csrf(AbstractHttpConfigurer::disable);
        /*build and return*/
        return httpSecurity.build();
    }
}
