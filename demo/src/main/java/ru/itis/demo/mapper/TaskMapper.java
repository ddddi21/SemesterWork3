package ru.itis.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.itis.demo.dto.TaskDto;
import ru.itis.demo.models.Task;


@Mapper
public interface TaskMapper {
    TaskMapper  INSTANCE = Mappers.getMapper(TaskMapper.class);

    @Mapping(target = "id", source = "id")
    TaskDto taskToTaskDto(Task task);
}