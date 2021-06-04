package ru.itis.demo.dto;

import lombok.Data;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class SignInFormDto {
    //TODO(fix messages doesn't work imenno tut blinb)
    @NotNull(message = "{errors.incorrect.email}")
    @Email(message = "{errors.incorrect.email}")
    private String email;

    @NotNull(message = "{errors.null.password}")
    private String password;
//    @NotNull(message = "{errors.null.age}")
//    @Min(message ="{errors.incorrect.age}", value = 0)
//        private Integer age;
}
