package ru.itis.demo.services.interfaces;

import ru.itis.demo.dto.UserDto;
import ru.itis.demo.dto.SignUpFormDto;

public interface SignUpServiceInterface {
    UserDto signUp(SignUpFormDto form);
}
