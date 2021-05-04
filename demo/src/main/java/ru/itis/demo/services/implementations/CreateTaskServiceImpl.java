package ru.itis.demo.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.demo.dto.TaskDto;
import ru.itis.demo.models.Task;
import ru.itis.demo.models.User;
import ru.itis.demo.repositories.TasksRepository;
import ru.itis.demo.repositories.UsersRepositoryInterface;
import ru.itis.demo.security.details.UserDetailsImpl;
import ru.itis.demo.services.interfaces.CreateTaskService;
@Service
@RequiredArgsConstructor
public class CreateTaskServiceImpl implements CreateTaskService {
    @Autowired
    private TasksRepository tasksRepository;

    @Autowired
    private UsersRepositoryInterface usersRepositoryInterface;

    @Override
    public Task addTask(TaskDto taskDto, UserDetailsImpl userDetails) {
        User user = usersRepositoryInterface.findByEmail(userDetails.getUsername()).get();
        Task task = Task.builder()
        .text(taskDto.getText())
        .ownerId(user.getId())
        .build();
        tasksRepository.save(task);
        return task;
    }
}
