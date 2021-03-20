package ru.itis.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.demo.services.interfaces.UsersServiceInterface;

@Controller
public class UserAccountController {
    @Autowired
    private UsersServiceInterface usersServiceInterface;

    @GetMapping("/users")
    public String getUsersPage(Model model){
        model.addAttribute("usersList", usersServiceInterface.getAllUsers());
        return "all_user_page";
    }

    @PostMapping("/banAll")
    public String banUsers(){
        usersServiceInterface.banAll();
        return "redirect:/users";
    }


}
