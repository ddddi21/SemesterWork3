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
    private String username;
    private String imagepath;
    private String gender;
    private String code;
    private String phone;

    public static UserDto from(User user){
        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .username(user.getUsername())
                .gender(user.getGender())
                .phone(user.getPhone())
                .imagepath(user.getImagepath())
                .build();
    }

    public static List<UserDto> form(List<User> users){
        return users.stream().map(UserDto::from).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":\"" + id +
                "\", \"name\":\"" + username +
                "\", \"email\":\"" + email +
                "\", \"phone\":\"" + phone +
                "\", \"gender\":\"" + gender +
                "\", \"image path\":\"" + gender +
                "\"}";
    }
}

