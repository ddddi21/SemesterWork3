package ru.itis.demo.services.interfaces;

import ru.itis.demo.dto.SignInFormDto;

public interface SignInServiceInterface {
    Boolean signIn(SignInFormDto form);
    Boolean checkPassword(SignInFormDto user);
    Boolean isAlreadyExist(SignInFormDto user);

}
