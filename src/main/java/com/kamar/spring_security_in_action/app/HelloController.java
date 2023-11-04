package com.kamar.spring_security_in_action.app;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.annotations.OpenAPI31;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

/**
 * the hello controller.
 * @author kamar baraka.*/

@RestController
@OpenAPIDefinition(info = @Info(
        title = "Spring Security In Action",
        description = "apis exposed by the spring security in action application",
        contact = @Contact(name = "kamar baraka", email = "kamar254baraka@gmail.com"),
        version = "1.0.0.1",
        summary = "APIs"
))
@OpenAPI31
@Tag(name = "Hello", description = "greeting API")
@RequestMapping(value = {"/api/v1/hello"})
public class HelloController {

    /**
     * greet the user.
     *
     * @return the greeting
     */
    @GetMapping
    @Operation(summary = "hello API", description = "an api to greet the user", tags = {"Hello"})
    @PreAuthorize("permitAll()")
    public ResponseEntity<EntityModel<Message>> hello(/*@AuthenticationPrincipal UserDetails userDetails*/){

        /*if (userDetails == null)
            return ResponseEntity.notFound().build();*/
        /*the message*/
        Message message = new Message("Hello!", "user");
        /*build an Entity Model*/
        EntityModel<Message> resource = EntityModel.of(message);
        /*set the link*/
        resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(AnotherController.class).another()).withSelfRel());
        /*return hello greeting*/
        return ResponseEntity.status(HttpStatus.PERMANENT_REDIRECT).header("Location",
                "/api/v1/another").body(resource);
    }
}
