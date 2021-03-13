package ru.itis.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.demo.dto.UserForm;
import ru.itis.demo.helpers.CookieHelper;
import ru.itis.demo.services.interfaces.SignUpServiceInterface;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SignUpController {
    @Autowired
    private SignUpServiceInterface signUpServiceInterface;
    @Autowired
    private CookieHelper cookieHelper;

    @GetMapping("/signUp")
    public String getSignUpPage(HttpServletRequest request) {
//        if (!cookieHelper.checkCookie(request,"cookie_email")) {
//            return "sign_up_page";
//        }else {
//            return "redirect:/users";
//            //later change to userProfile page
//        }
        return "sign_up_page";
    }

    @PostMapping("/signUp")
    public String signUp(UserForm form, HttpServletResponse response) {
//        if(signUpServiceInterface.signUp(form)){
//            cookieHelper.addCookie(form,response,"cookie_email");
//            return "redirect:/signUp";
//            //put message on page "sign up" is success
//        } else {
//            return "redirect:/signUp";
//            //put message on page "sign up" is failed
//        }
        if (signUpServiceInterface.signUp(form)) {
            return "redirect:/signIn";
        } else {
            return "redirect:/signUp";
        }
    }
}
