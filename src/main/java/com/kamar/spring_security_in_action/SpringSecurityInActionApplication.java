package com.kamar.spring_security_in_action;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.hateoas.config.EnableHypermediaSupport;

@SpringBootApplication
@EnableHypermediaSupport(type = {EnableHypermediaSupport.HypermediaType.HAL})
public class SpringSecurityInActionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityInActionApplication.class, args);
    }

}
