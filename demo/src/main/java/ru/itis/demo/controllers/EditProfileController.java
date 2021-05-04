package ru.itis.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.itis.demo.dto.EditProfileDto;
import ru.itis.demo.dto.UserDto;
import ru.itis.demo.repositories.UsersRepositoryInterface;
import ru.itis.demo.security.details.UserDetailsImpl;
import ru.itis.demo.services.implementations.UsersServiceInterfaceImpl;

@Controller
public class EditProfileController {
    @Autowired
    private UsersServiceInterfaceImpl usersServiceInterface;

    @GetMapping("/editProfile")
    public String getEditProfilePage(){
        return "edit_profile_page";
    }
    @PostMapping("/editProfile")
    public String editProfile (@AuthenticationPrincipal UserDetailsImpl user, EditProfileDto form, RedirectAttributes attributes){
        UserDto changedUser;
        if((!form.getPassword().isEmpty() && form.getRepeatPassword().isEmpty())
                || ((form.getPassword().isEmpty() && !form.getRepeatPassword().isEmpty()))){
            attributes.addFlashAttribute("error", "enter both passwords");
            return "redirect:/editProfile";
        } else {
            if (!form.getPassword().isEmpty() && !form.getRepeatPassword().isEmpty() &&
                    !form.getRepeatPassword().equals(form.getPassword())) {
                attributes.addFlashAttribute("error", "passwords not same");
                return "redirect:/editProfile";
            } else{
                changedUser = usersServiceInterface.editProfile(user,form);
                attributes.addFlashAttribute("error", "success edit!");
                return "redirect:/editProfile";
            }
        }
    }
}
