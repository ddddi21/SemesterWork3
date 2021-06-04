package ru.itis.demo.dto;


import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class EditProfileDto {
    private String password;
    private String repeatPassword;
    private String username;
    private String gender;
}
