package ru.itis.demo.controllers;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.itis.demo.dto.SignInFormDto;
import ru.itis.demo.dto.TokenDto;
import ru.itis.demo.security.details.UserDetailsImpl;
import ru.itis.demo.services.interfaces.SignInServiceInterface;


@RestController
public class SignInController {

    @Autowired
    private SignInServiceInterface signInService;

    @ApiOperation(value = "авторизация")
    @PostMapping("/signIn")
    public ResponseEntity<TokenDto> signIn(@RequestBody SignInFormDto signInFormDto) {
        if(signInService.isAvailableUser(signInFormDto)){
            return ResponseEntity.ok(signInService.signIn(signInFormDto));
        } else{
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }
}
