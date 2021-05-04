package ru.itis.demo.services.interfaces;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import ru.itis.demo.dto.EditProfileDto;
import ru.itis.demo.dto.UserDto;
import ru.itis.demo.security.details.UserDetailsImpl;

import java.util.List;

public interface UsersServiceInterface {
    List<UserDto> getAllUsers();
    UserDto editProfile(@AuthenticationPrincipal UserDetailsImpl userDetails, EditProfileDto editProfileDto);
    void banAll();
}
