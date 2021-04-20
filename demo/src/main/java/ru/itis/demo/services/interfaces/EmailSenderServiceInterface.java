package ru.itis.demo.services.interfaces;

import ru.itis.demo.dto.UserDto;
import ru.itis.demo.dto.UserForm;

public interface EmailSenderServiceInterface {
    void sendMessage(String subject, String email, String html);
}
