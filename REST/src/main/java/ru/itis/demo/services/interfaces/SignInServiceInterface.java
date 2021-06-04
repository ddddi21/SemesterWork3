package ru.itis.demo.services.interfaces;

import ru.itis.demo.dto.SignInFormDto;
import ru.itis.demo.dto.TokenDto;

public interface SignInServiceInterface {
    TokenDto signIn(SignInFormDto formDto);
    Boolean isAvailableUser(SignInFormDto formDto);

}
