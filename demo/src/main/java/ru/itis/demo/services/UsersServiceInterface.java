package ru.itis.demo.services;

import ru.itis.demo.dto.UserDto;

import java.util.List;

public interface UsersServiceInterface {
    List<UserDto> getAllUsers();
}
