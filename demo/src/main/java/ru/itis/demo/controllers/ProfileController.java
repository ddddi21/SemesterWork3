package ru.itis.demo.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.demo.security.details.UserDetailsImpl;
import ru.itis.demo.security.details.UserDetailsServiceImpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

@Controller
public class ProfileController {

    @GetMapping("/profile")
    public String getProfilePage(@AuthenticationPrincipal UserDetailsImpl user, Model model) throws IOException {
        System.out.println(user.getImagePath());
        String imagepath = user.getImagePath();
        String imgAsBase64 = "";
        if(!imagepath.equals("null")) {
            File img = new File(user.getImagePath());
            byte[] data = Files.readAllBytes(img.toPath());
            byte[] encoded = Base64.getEncoder().encode(data);
            String imgDataAsBase64 = new String(encoded);
            imgAsBase64 = "data:image/png;base64," + imgDataAsBase64;
            //костыль
        }

        model.addAttribute("userEmail", user.getUsername());
        model.addAttribute("imagepath", imgAsBase64);
        return "user_page";
    }
}
