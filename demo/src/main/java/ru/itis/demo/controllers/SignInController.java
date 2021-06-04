package ru.itis.demo.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.itis.demo.dto.SignInFormDto;
import ru.itis.demo.security.details.UserDetailsImpl;


import javax.servlet.http.HttpServletRequest;

@Controller
public class SignInController {

    @GetMapping("/signIn")
    public String getSignInPage() {
        return "sign_in_page";
    }


    @PostMapping("/signIn")
    public String postSignInPage(@AuthenticationPrincipal UserDetailsImpl userDetails, SignInFormDto user, Model model, RedirectAttributes redirectAttributes) {
        if(user.getEmail().isEmpty() || user.getPassword().isEmpty()){
//            model.addAttribute("error", "empty fields");
            redirectAttributes.addFlashAttribute("error", "empty fields");
            return "sign_in_page";
        } else{
            if (!userDetails.isEnabled()){
                redirectAttributes.addFlashAttribute("error", "confirm your account at " +userDetails.getUsername());
            }
        }
        return "sign_in_page";
    }
}
