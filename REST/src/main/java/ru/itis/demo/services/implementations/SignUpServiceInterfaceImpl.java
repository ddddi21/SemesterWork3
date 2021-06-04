package ru.itis.demo.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itis.demo.dto.SignUpFormDto;
import ru.itis.demo.dto.UserDto;
import ru.itis.demo.dto.SignInFormDto;
import ru.itis.demo.models.User;
import ru.itis.demo.repositories.UsersRepositoryInterface;
import ru.itis.demo.services.interfaces.SignUpServiceInterface;

import java.util.UUID;

@Component
public class SignUpServiceInterfaceImpl implements SignUpServiceInterface {
    @Autowired
    private UsersRepositoryInterface usersRepositoryInterface;
    String email;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto signUp(SignUpFormDto form) {
        if(form.getEmail().isEmpty() || form.getPassword().isEmpty()){
            //delete when messages will be fixed
            return null;
        } else {
            String uuid = UUID.randomUUID().toString();
            User newUser = User.builder()
                    .email(form.getEmail())
                    .password(passwordEncoder.encode(form.getPassword()))
                    .role(User.Role.USER)
//                    .state(User.State.ACTIVE)
                    .currentConfirmationCode((uuid))
                    .gender(form.getGender())
                    .username(form.getUsername())
                    .phone(form.getPhone())
                    .build();
            if(!usersRepositoryInterface.existsByEmail(newUser.getEmail())) {
                usersRepositoryInterface.save(newUser);
                return UserDto.from(newUser);
            } else return null;
        }
    }


}
