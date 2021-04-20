package ru.itis.demo.services.interfaces;

import ru.itis.demo.dto.UserDto;

public interface EmailServiceInterface {
    void sendEmail(UserDto userDto);

}
