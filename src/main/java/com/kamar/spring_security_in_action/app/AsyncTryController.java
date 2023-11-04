package com.kamar.spring_security_in_action.app;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

/**
 * controller to test async web programming.
 * @author kamar baraka.*/

@RestController("async")
@RequestMapping(value = "/api/async")
public class AsyncTryController {


    @GetMapping
    @Operation(tags = {"Async Test"}, summary = "api to test async web programming")
//    @Async
    public CompletableFuture<String> loggedInUser(@AuthenticationPrincipal UserDetails authenticatedUser){

        return CompletableFuture.supplyAsync(
                () -> {
                    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                    return authentication.getName()+ authenticatedUser.getUsername();
                }, Executors.newCachedThreadPool());
    }
}
