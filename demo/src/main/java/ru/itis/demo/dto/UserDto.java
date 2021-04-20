package ru.itis.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.demo.models.User;

import java.util.List;
import java.util.stream.Collectors;

//то что показываем пользователю

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String email;
    private String code;

    public static UserDto from(User user){
        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .code(user.getCurrentConfirmationCode())
                .build();
    }

    public static List<UserDto> form(List<User> users){
        return users.stream().map(UserDto::from).collect(Collectors.toList());
    }
}
