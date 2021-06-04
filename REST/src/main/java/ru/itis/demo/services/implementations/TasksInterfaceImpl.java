package ru.itis.demo.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.itis.demo.dto.TaskDto;
import ru.itis.demo.models.Task;
import ru.itis.demo.models.User;
import ru.itis.demo.repositories.TasksRepository;
import ru.itis.demo.repositories.UsersRepositoryInterface;
import ru.itis.demo.security.details.UserDetailsImpl;
import ru.itis.demo.services.interfaces.TasksInterface;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TasksInterfaceImpl implements TasksInterface {
    @Autowired
    private TasksRepository tasksRepository;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


    @Autowired
    private UsersRepositoryInterface usersRepositoryInterface;
    @Override
    public List<Task> findAllTask(UserDetailsImpl userDetails) {
        User user = usersRepositoryInterface.findByEmail(userDetails.getUsername()).get();
        return tasksRepository.findAllByOwnerId(user.getId());
    }

    @Override
    public List<Task> findAllByOwnerIdAndTitle(UserDetailsImpl userDetails, String name) {
        User user = usersRepositoryInterface.findByEmail(userDetails.getUsername()).get();
        return tasksRepository.findAllByOwnerIdAndTitle(user.getId(), name);
    }

    @Override
    public TaskDto editTask(UserDetailsImpl userDetails, TaskDto taskDto) {
        User user = usersRepositoryInterface.findByEmail(userDetails.getUsername()).get();
        Task changedTask = Task.builder()
                .id(taskDto.getId())
                .title(taskDto.getTitle())
                .ownerId(user.getId())
                .text(taskDto.getText())
                .deadline(taskDto.getDeadline())
                .build();
        tasksRepository.save(changedTask);
        return TaskDto.from(changedTask);
    }

    @Override
    public void deleteTask(UserDetailsImpl userDetails, Task task) {
        Task taskDelete = tasksRepository.findById(task.getId()).get();
        tasksRepository.delete(taskDelete);
    }

    @Scheduled(fixedRate = 5000)
    public void checkAvailableDeadline() {
        String currentDate = dateFormat.format(new Date());

    }
    @Override
    public Task addTask(TaskDto taskDto, UserDetailsImpl userDetails) {
        User user = usersRepositoryInterface.findByEmail(userDetails.getUsername()).get();
        String desc = taskDto.getText();
        if(taskDto.getText() == null) {
            desc = "-";
        }
        Task task = Task.builder()
                .text(desc)
                .title(taskDto.getTitle())
                .deadline(taskDto.getDeadline())
                .ownerId(user.getId())
                .build();
        tasksRepository.save(task);
        return task;
    }
}
