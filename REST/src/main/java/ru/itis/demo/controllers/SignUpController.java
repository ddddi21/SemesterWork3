package ru.itis.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.demo.dto.SignUpFormDto;
import ru.itis.demo.dto.UserDto;
import ru.itis.demo.services.implementations.SmsServiceImpl;
import ru.itis.demo.services.interfaces.EmailServiceInterface;
import ru.itis.demo.services.interfaces.SignUpServiceInterface;

@RestController
public class SignUpController {
    @Autowired
    private SignUpServiceInterface signUpServiceInterface;

    @Autowired
    private EmailServiceInterface emailSenderServiceInterface;

    @Autowired
    private SmsServiceImpl smsService;

    @PostMapping("/signUp")
    public ResponseEntity<String> signUp(@RequestBody SignUpFormDto form) {
        UserDto userDto;
        if(form.getEmail().isEmpty() || form.getPassword().isEmpty() || form.getGender().isEmpty()||
            form.getUsername().isEmpty() || form.getRepeatPassword().isEmpty()){
            return ResponseEntity.ok("{error: empty fields}");
        } else {
            if (!form.getRepeatPassword().equals(form.getPassword())) {
                return ResponseEntity.ok("{error: passwords not same}");

            } else {
                if (form.getPassword().length() < 4) {
                    return ResponseEntity.ok("{error: passwords should be more than 4 characters}");
                } else {
                    if ((userDto = signUpServiceInterface.signUp(form)) != null) {
                        emailSenderServiceInterface.sendEmail(userDto);
                        smsService.sendSms(form.getPhone(), "Вы зарегистрированы!");
                        return ResponseEntity.ok(userDto.toString());
                    } else {
                        return ResponseEntity.ok("{error: this email already exist");
                    }
                }
            }
        }
    }
}
