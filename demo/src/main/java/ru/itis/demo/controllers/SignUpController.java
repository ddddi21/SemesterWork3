package ru.itis.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.itis.demo.dto.SignUpFormDto;
import ru.itis.demo.dto.UserDto;
import ru.itis.demo.dto.SignInFormDto;
import ru.itis.demo.services.implementations.SmsServiceImpl;
import ru.itis.demo.services.interfaces.EmailServiceInterface;
import ru.itis.demo.services.interfaces.SignUpServiceInterface;

@Controller
public class SignUpController {
    @Autowired
    private SignUpServiceInterface signUpServiceInterface;

    @Autowired
    private EmailServiceInterface emailSenderServiceInterface;

    @Autowired
    private SmsServiceImpl smsService;

    @GetMapping("/signUp")
    public String getSignUpPage() {
        return "sign_up_page";
    }

    @PostMapping("/signUp")
    public String signUp(SignUpFormDto form, Model model, RedirectAttributes redirectAttributes) {
        UserDto userDto;
        if(form.getEmail().isEmpty() || form.getPassword().isEmpty() || form.getGender().isEmpty()||
            form.getUsername().isEmpty() || form.getRepeatPassword().isEmpty()){
            redirectAttributes.addFlashAttribute("error", "empty fields");
            return "redirect:/signUp";
        } else {
            if (!form.getRepeatPassword().equals(form.getPassword())) {
                redirectAttributes.addFlashAttribute("error", "passwords not same");
                return "redirect:/signUp";
            } else {
//        if(form.getPassword()|| form.) //add empty fields checking
                if ((userDto = signUpServiceInterface.signUp(form)) != null) {
                    emailSenderServiceInterface.sendEmail(userDto);
                    smsService.sendSms(form.getPhone(), "Вы зарегистрированы!");
                    redirectAttributes.addFlashAttribute("error", "follow to " +form.getEmail() + " to confirm your account"); //doesn't work
                    return "redirect:/signIn";
                } else {
                    redirectAttributes.addFlashAttribute("error", "this email already exist");
//            model.addAttribute("error", "this email already exist"); this shit doesn't work again
                    return "redirect:/signUp";
                }
            }
        }
    }
}
