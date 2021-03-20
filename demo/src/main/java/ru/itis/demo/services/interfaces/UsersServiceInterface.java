package ru.itis.demo.services.interfaces;

import ru.itis.demo.dto.UserDto;

import java.util.List;

public interface UsersServiceInterface {
    List<UserDto> getAllUsers();

    void banAll();
}
