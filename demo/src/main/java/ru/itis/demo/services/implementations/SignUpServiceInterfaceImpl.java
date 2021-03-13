package ru.itis.demo.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.demo.dto.UserForm;
import ru.itis.demo.models.User;
import ru.itis.demo.repositories.UsersRepositoryInterface;
import ru.itis.demo.services.interfaces.SignUpServiceInterface;

@Component
public class SignUpServiceInterfaceImpl implements SignUpServiceInterface {
    @Autowired
    private UsersRepositoryInterface usersRepositoryInterface;
    String email;

    @Override
    public Boolean signUp(UserForm form) {
        if(form.getEmail().isEmpty() || form.getPassword().isEmpty()){
            //delete when messages will be fixed
            return false;
        } else {
            User newUser = User.builder().email(form.getEmail()).password(form.getPassword()).build();
            if(!usersRepositoryInterface.existsByEmail(newUser.getEmail())) {
                usersRepositoryInterface.save(newUser);
                return true;
            } else return false;
        }
    }

}
