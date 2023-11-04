package com.kamar.spring_security_in_action.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * the home controller.
 * @author kamar baraka.*/

@Controller
@RequestMapping(value = {"api/home"})
public class HomeController {

    @GetMapping
    @ResponseBody
    public String userHome(){

        return "home";
    }


    @GetMapping(value = {"admin"})
    @ResponseBody
    public String adminHome(){

        return "adminHome";
    }
}
