package ru.itis.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.demo.dto.UserForm;
import ru.itis.demo.helpers.CookieHelper;
import ru.itis.demo.services.implementations.SignInServiceInterfaceImpl;
import ru.itis.demo.services.interfaces.UsersServiceInterface;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SignInController {
    @Autowired
    private UsersServiceInterface usersServiceInterface;
    @Autowired
    private CookieHelper cookieHelper;
    @Autowired
    private SignInServiceInterfaceImpl signInServiceInterface;

    @GetMapping("/signIn")
    public String getSignInPage(HttpServletRequest request) {
//        if (!cookieHelper.checkCookie(request, "cookie_email")) {
////            return "sign_in_page";
//        } else {
////            return "redirect:/users";
//            //later change to userProfile page
//                        return "sign_in_page";
//        }
                    return "sign_in_page";
    }

    //add cookie to "remember" if user want it

//    @PostMapping("/signIn")
//    public String SignIn(UserForm form, HttpServletResponse response, Model modelAndView){
//        if (!signInServiceInterface.isAlreadyExist(form)){
//            return "sign_in_page"; //todo add error message
//        } else {
//            if(signInServiceInterface.checkPassword(form)){
//                modelAndView.addAttribute("userEmail", form.getEmail()); //?? why don't work
//                return "user_page";
//            }else return "sign_in_page";
//        }
//    }
    //зря делала молодец, за тебя это все сделает спринг секьюрити
//    @PostMapping("/signIn")
//    public String SignIn(UserForm userForm, Model model){
//        model.addAttribute("userEmail", userForm.getEmail());
//        return "user_page";
//    }
    //как добавлять атрибуты тогда(((
}
