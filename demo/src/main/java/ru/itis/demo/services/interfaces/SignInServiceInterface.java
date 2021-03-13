package ru.itis.demo.services.interfaces;

import ru.itis.demo.dto.UserForm;
import ru.itis.demo.models.User;

public interface SignInServiceInterface {
    Boolean signIn(UserForm form);
    Boolean checkPassword(UserForm user);
    Boolean isAlreadyExist(UserForm user);

}
