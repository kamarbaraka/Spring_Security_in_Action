package com.kamar.spring_security_in_action.app;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.annotations.OpenAPI31;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.keygen.BytesKeyGenerator;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.security.crypto.keygen.StringKeyGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * another test controller.
 * @author kamar baraka.*/

@OpenAPI31
@RestController
@RequestMapping(value = {"/api/v1/another"})
@Tag(name = "Another", description = "another testing api")
public class AnotherController {


    @GetMapping
    @Operation(tags = {"Another"}, summary = "another message", description = "get another message")
    @PreAuthorize("permitAll()")
    public ResponseEntity<EntityModel<Message>> another(){


        /*create the message*/
        Message message = new Message("this is another message", "kamar");
        /*create an EntityModel for the message*/
        EntityModel<Message> resource = EntityModel.of(message);
        /*set the links*/
        resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(HelloController.class).hello()).withSelfRel());
        /*return the message entity as a response entity*/
        return ResponseEntity.ok(resource);
    }
}
