package ru.itis.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.demo.services.UsersServiceInterface;

@Controller
public class UsersController {
    @Autowired
    private UsersServiceInterface usersServiceInterface;

    @GetMapping("/users")
    public String getUsersPage(Model model){
        model.addAttribute("usersList", usersServiceInterface.getAllUsers());
        return "user_page";
    }

}
