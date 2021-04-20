package ru.itis.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.itis.demo.dto.UserDto;
import ru.itis.demo.models.User;

@Mapper
public interface UserMapper {
    UserMapper  INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "id", source = "user.id", defaultExpression = "java(java.util.UUID.randomUUID().toString())")
    UserDto userToUserDTO(User user);
}
