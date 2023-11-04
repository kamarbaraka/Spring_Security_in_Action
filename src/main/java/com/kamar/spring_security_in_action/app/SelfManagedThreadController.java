package com.kamar.spring_security_in_action.app;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.concurrent.DelegatingSecurityContextExecutorService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * test controller for self-managed threads.
 * @author kamar baraka.*/

@RestController
@RequestMapping(value = {"api/self"})
public class SelfManagedThreadController {

    @GetMapping
    @Operation(summary = "api for self managed thread")
    @PreAuthorize("permitAll()")
    public CompletableFuture<String> selfManaged() {

        /*create, delegate and submit it to an executor service*/
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService = new DelegatingSecurityContextExecutorService(executorService);

        /*create the task to be executed on a separate thread*/
        /*return the response*/
        return CompletableFuture.supplyAsync(() -> {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            return authentication.getName();
        }, executorService);

    }
}
