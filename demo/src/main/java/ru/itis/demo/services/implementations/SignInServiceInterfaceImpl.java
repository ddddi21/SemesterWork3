package ru.itis.demo.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.itis.demo.dto.SignInFormDto;
import ru.itis.demo.models.User;
import ru.itis.demo.repositories.UsersRepositoryInterface;
import ru.itis.demo.services.interfaces.SignInServiceInterface;

@Component
public class SignInServiceInterfaceImpl implements SignInServiceInterface {
    @Autowired
    private UsersRepositoryInterface usersRepositoryInterface;

    //not using
    @Override
    public Boolean signIn(SignInFormDto form) {
        if(form.getEmail().isEmpty() || form.getPassword().isEmpty()){
            //delete when messages will be fixed
            return false;
        } else {
            User newUser = User.builder().email(form.getEmail()).password(form.getPassword()).build();
//            if (usersRepositoryInterface.)
            return true;
        }
    }


    //not using
    @Override
    public Boolean checkPassword(SignInFormDto user) {
        if(isAlreadyExist(user)){
            User new_user = usersRepositoryInterface.findByEmail(user.getEmail()).orElseThrow(()-> new UsernameNotFoundException("User not found"));
            if (
                    new_user.getPassword().equalsIgnoreCase(user.getPassword())){
                return true;
            }else return false;
        }else return false; //todo add error message later
    }

    @Override
    public Boolean isAlreadyExist(SignInFormDto user) {
        if(usersRepositoryInterface.existsByEmail(user.getEmail())) {
            return true;
        } else return false;
    }
}
