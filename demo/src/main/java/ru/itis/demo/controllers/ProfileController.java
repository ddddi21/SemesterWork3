package ru.itis.demo.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.demo.security.details.UserDetailsImpl;
import ru.itis.demo.security.details.UserDetailsServiceImpl;

@Controller
public class ProfileController {

    @GetMapping("/profile")
    public String getProfilePage(@AuthenticationPrincipal UserDetailsImpl user, Model model){
        System.out.println(user);
        model.addAttribute("userEmail", user.getUsername());
        return "user_page";
    }
}
