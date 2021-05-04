package ru.itis.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.demo.dto.UserDto;
import ru.itis.demo.dto.UserForm;
import ru.itis.demo.services.implementations.EmailSenderServiceInterfaceImpl;
import ru.itis.demo.services.interfaces.EmailServiceInterface;
import ru.itis.demo.services.interfaces.SignUpServiceInterface;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SignUpController {
    @Autowired
    private SignUpServiceInterface signUpServiceInterface;

    @Autowired
    private EmailServiceInterface emailSenderServiceInterface;

    @GetMapping("/signUp")
    public String getSignUpPage() {
        return "sign_up_page";
    }

    @PostMapping("/signUp")
    public String signUp(UserForm form, Model model) {
        UserDto userDto;
//        if(form.getPassword()|| form.) //add empty fields checking
        if ((userDto = signUpServiceInterface.signUp(form))!= null) {
            emailSenderServiceInterface.sendEmail(userDto);
            return "redirect:/signIn";

        } else {
            model.addAttribute("message", "this email already exist");
            return "redirect:/signUp";
        }
    }
}
