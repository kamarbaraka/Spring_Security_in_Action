package com.kamar.spring_security_in_action.app;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kamar baraka.*/

@RestController
@RequestMapping(value = {"api/v1/req"})
public class RequestTryController {

    @GetMapping
    public ResponseEntity<String > tryThis(@RequestHeader("name") String name){
        return ResponseEntity.ok(name);
    }
}
