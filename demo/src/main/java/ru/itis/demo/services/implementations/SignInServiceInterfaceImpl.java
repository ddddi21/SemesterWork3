package ru.itis.demo.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.itis.demo.dto.UserForm;
import ru.itis.demo.models.User;
import ru.itis.demo.repositories.UsersRepositoryInterface;
import ru.itis.demo.services.interfaces.SignInServiceInterface;

@Component
public class SignInServiceInterfaceImpl implements SignInServiceInterface {
    @Autowired
    private UsersRepositoryInterface usersRepositoryInterface;

    @Override
    public Boolean signIn(UserForm form) {
        if(form.getEmail().isEmpty() || form.getPassword().isEmpty()){
            //delete when messages will be fixed
            return false;
        } else {
            User newUser = User.builder().email(form.getEmail()).password(form.getPassword()).build();
//            if (usersRepositoryInterface.)
            return true;
        }
    }


    @Override
    public Boolean checkPassword(UserForm user) {
        if(isAlreadyExist(user)){
            User new_user = usersRepositoryInterface.findByEmail(user.getEmail()).orElseThrow(()-> new UsernameNotFoundException("User not found"));
            if (
                    new_user.getPassword().equalsIgnoreCase(user.getPassword())){
                return true;
            }else return false;
        }else return false; //todo add error message later
    }

    @Override
    public Boolean isAlreadyExist(UserForm user) {
        if(usersRepositoryInterface.existsByEmail(user.getEmail())) {
            return true;
        } else return false;
    }
}
