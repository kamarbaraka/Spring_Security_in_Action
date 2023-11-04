package com.kamar.spring_security_in_action.app;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * a custom authentication entry point for http basic authentication method.
 * @author kamar baraka.*/

@Component
public class CustomAuthenticationEntrypoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {

        /*add a custom header for failed response*/
        response.addHeader("message", "sorry, you aren't authenticated");
        response.sendError(HttpStatus.UNAUTHORIZED.value());

    }
}
