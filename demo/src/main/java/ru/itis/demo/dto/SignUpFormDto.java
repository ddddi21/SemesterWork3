package ru.itis.demo.dto;

import lombok.Data;
import ru.itis.demo.models.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class SignUpFormDto {
        @NotNull(message = "{errors.incorrect.email}")
        @Email(message = "{errors.incorrect.email}")
        private String email;

        @Min(value = 4, message = "{errors.incorrect.min.password}")
        @NotNull(message = "{errors.null.password}")
        private String password;

        @Min(value = 4, message = "{errors.incorrect.min.password}")
        @NotNull
        private String repeatPassword;
        @NotNull
        private String username;
        @NotNull
         private String gender;
        @NotNull
        private String phone;
}
