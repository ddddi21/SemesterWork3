package ru.itis.demo.controllers;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.demo.dto.UserDto;
import ru.itis.demo.models.User;
import ru.itis.demo.repositories.UsersRepositoryInterface;
import ru.itis.demo.security.details.UserDetailsImpl;
import ru.itis.demo.security.details.UserDetailsServiceImpl;
import ru.itis.demo.services.interfaces.UsersServiceInterface;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

@RestController
public class ProfileController {
    @Autowired
    private UsersServiceInterface usersService;

    @ApiOperation(value = "страница пользователя")
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/profile")
    public ResponseEntity<UserDto> getProfilePage() throws IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl user = (UserDetailsImpl) authentication.getDetails();
        return ResponseEntity.ok(UserDto.from(usersService.getUser(user)));
    }
}
