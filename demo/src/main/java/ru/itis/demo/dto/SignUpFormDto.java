package ru.itis.demo.dto;

import lombok.Data;
import ru.itis.demo.models.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class SignUpFormDto {
        //TODO(fix messages doesn't work)
        @NotNull(message = "{errors.incorrect.email}")
        @Email(message = "{errors.incorrect.email}")
        private String email;

        @NotNull(message = "{errors.null.password}")
        private String password;

        @NotNull
        private String repeatPassword;
        @NotNull
        private String username;
        @NotNull
         private String gender;
}
