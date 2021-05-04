package ru.itis.demo.services.interfaces;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import ru.itis.demo.dto.TaskDto;
import ru.itis.demo.models.Task;
import ru.itis.demo.security.details.UserDetailsImpl;

public interface CreateTaskService {
    Task addTask(TaskDto taskDto, @AuthenticationPrincipal UserDetailsImpl userDetails);
}
