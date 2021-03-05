package ru.itis.demo.services;

import ru.itis.demo.dto.UserForm;
import ru.itis.demo.models.User;

public interface SignUpServiceInterface {
    Boolean signUp(UserForm form);
    Boolean isUserAlreadyCreated(User user);
}
