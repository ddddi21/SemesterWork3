package ru.itis.demo.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.demo.dto.UserDto;
import ru.itis.demo.models.User;
import ru.itis.demo.repositories.UsersRepositoryInterface;
import ru.itis.demo.services.interfaces.UsersServiceInterface;

import java.util.List;

@Component
public class UsersServiceInterfaceImpl implements UsersServiceInterface {
    @Autowired
    private UsersRepositoryInterface usersRepositoryInterface;

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = usersRepositoryInterface.findAll();
        return UserDto.form(users);
    }
}
