package ru.itis.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.demo.security.details.UserDetailsImpl;


import javax.servlet.http.HttpServletRequest;

@Controller
public class SignInController {

    @GetMapping("/signIn")
    public String getSignInPage() {
        return "sign_in_page";
    }

    //не заходит сюда
    @PostMapping("/signIn")
    public String postSignInPage(@AuthenticationPrincipal UserDetailsImpl user, Model model) {
        if(user.getUsername().isEmpty() || user.getPassword().isEmpty()){
            model.addAttribute("error", "empty fields");
        }
        return "sign_in_page";
    }
}
