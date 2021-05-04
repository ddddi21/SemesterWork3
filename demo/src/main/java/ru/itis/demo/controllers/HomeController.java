package ru.itis.demo.controllers;


import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.security.PermitAll;

@Controller
public class HomeController {

    @PermitAll
    @GetMapping("/home")
    public String getHomePage(Authentication authentication){
        if (authentication != null) {
            return "redirect:/profile";
        } else {
            return "home_page";
        }
    }
}
