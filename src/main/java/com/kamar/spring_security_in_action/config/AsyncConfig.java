package com.kamar.spring_security_in_action.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * asynchronous methods configuration class.
 * @author kamar baraka.*/

@Configuration
//@EnableAsync
public class AsyncConfig {

    @Bean
    public InitializingBean initializingBean(){

        return () -> SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);
    }
}
