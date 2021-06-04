package ru.itis.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.demo.dto.UserDto;
import ru.itis.demo.services.interfaces.UsersServiceInterface;

import java.util.List;

@RestController
public class UserAccountController {
    @Autowired
    private UsersServiceInterface usersServiceInterface;

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getUsers(){
        return ResponseEntity.ok(usersServiceInterface.getAllUsers());
    }

}
