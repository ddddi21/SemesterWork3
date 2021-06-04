package ru.itis.demo.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.itis.demo.dto.EditProfileDto;
import ru.itis.demo.dto.TokenDto;
import ru.itis.demo.dto.UserDto;
import ru.itis.demo.repositories.UsersRepositoryInterface;
import ru.itis.demo.security.details.UserDetailsImpl;
import ru.itis.demo.services.implementations.UsersServiceInterfaceImpl;

@RestController
public class EditProfileController {
    @Autowired
    private UsersServiceInterfaceImpl usersServiceInterface;

    @ApiOperation(value = "настройки пользователя")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Успешно изменено", response = EditProfileDto.class)})
    @PreAuthorize("isAuthenticated()")
    @PatchMapping("/editProfile")
    public ResponseEntity<String> updateProfile (@RequestBody EditProfileDto form){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl user = (UserDetailsImpl) authentication.getDetails();
        UserDto changedUser;
        if((!form.getPassword().isEmpty() && form.getRepeatPassword().isEmpty())
                || ((form.getPassword().isEmpty() && !form.getRepeatPassword().isEmpty()))){
            return ResponseEntity.ok("error: empty fields");
        } else {
            if (!form.getPassword().isEmpty() && !form.getRepeatPassword().isEmpty() &&
                    !form.getRepeatPassword().equals(form.getPassword())) {
                return ResponseEntity.ok("{error: passwords not same}");
            } else{
                changedUser = usersServiceInterface.editProfile(user,form);
                return ResponseEntity.ok(changedUser.toString());
            }
        }
    }
}
