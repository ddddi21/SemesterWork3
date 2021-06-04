package ru.itis.demo.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itis.demo.dto.EditProfileDto;
import ru.itis.demo.dto.UserDto;
import ru.itis.demo.mapper.UserMapper;
import ru.itis.demo.models.User;
import ru.itis.demo.repositories.UsersRepositoryInterface;
import ru.itis.demo.security.details.UserDetailsImpl;
import ru.itis.demo.services.interfaces.UsersServiceInterface;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsersServiceInterfaceImpl implements UsersServiceInterface {
    @Autowired
    private UsersRepositoryInterface usersRepositoryInterface;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = usersRepositoryInterface.findAll();
        List<UserDto> userDtoList = new ArrayList<>();
        for(User user:users){
            userDtoList.add(UserDto.from(user));
        }
        return userDtoList;
    }

    @Override
    public UserDto editProfile(@AuthenticationPrincipal UserDetailsImpl userDetails, EditProfileDto form) {
        User oldUser = usersRepositoryInterface.findByEmail(userDetails.getUsername()).get();
        User changedUser = User.builder()
                .password(passwordEncoder.encode(form.getPassword()))
                .gender(form.getGender())
                .username(form.getUsername())
                .role(oldUser.getRole())
                .currentConfirmationCode(oldUser.getCurrentConfirmationCode())
                .id(oldUser.getId())
                .imagepath(oldUser.getImagepath())
                .email(oldUser.getEmail())
                .state(oldUser.getState())
                .build();
        if (form.getGender().isEmpty() || form.getGender() == null) {
            changedUser.setGender(oldUser.getGender());
        }
        if(form.getPassword().isEmpty()){
            changedUser.setPassword(oldUser.getPassword());
        }
        if(form.getUsername().isEmpty()){
            changedUser.setUsername(oldUser.getUsername());
        }
        usersRepositoryInterface.save(changedUser);
        return UserDto.from(changedUser);
    }

    @Override
    public void banAll() {
        List<User> users = usersRepositoryInterface.findAll();
        for(User user: users){
            if(!user.isAdmin()){
                user.setState(User.State.BANNED);
                usersRepositoryInterface.save(user);
            }
        }
    }

    @Override
    public User getUser(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        User user = usersRepositoryInterface.findByEmail(userDetails.getUsername()).get();
        return User.builder()
                .email(user.getEmail())
                .gender(user.getGender())
                .id(user.getId())
                .role(user.getRole())
                .username(user.getUsername())
                .imagepath(user.getImagepath())
                .phone(user.getPhone())
                .state(user.getState())
                .build();
    }
}
