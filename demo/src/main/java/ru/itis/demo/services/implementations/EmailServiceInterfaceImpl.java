package ru.itis.demo.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.demo.dto.UserDto;
import ru.itis.demo.services.interfaces.EmailSenderServiceInterface;
import ru.itis.demo.services.interfaces.EmailServiceInterface;
import ru.itis.demo.services.interfaces.TemplateMakerInterface;

import java.util.HashMap;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class EmailServiceInterfaceImpl implements EmailServiceInterface {
    private final TemplateMakerInterface templateProcessor;
    private final EmailSenderServiceInterface emailSenderServiceInterface;
    @Override
    public void sendEmail(UserDto userDto) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("email", userDto.getEmail());
        parameters.put("link", "http://localhost:8099/" + "confirm/" + userDto.getCode());
        sendMail(parameters, "mail.ftl", userDto.getEmail(), "Confirm your registration");
    }


    private void sendMail(Map<String, String> parameters, String template, String email, String subject) {
        String html = templateProcessor.makeTemplate(parameters, template);
        emailSenderServiceInterface.sendMessage(subject, email, html);
    }
}
