package ru.itis.demo.services.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import ru.itis.demo.dto.TasksPageDto;
import ru.itis.demo.models.Task;
import ru.itis.demo.security.details.UserDetailsImpl;

import java.util.List;


public interface AllTasksInterface {
        Page<Task> findAllTask(@AuthenticationPrincipal UserDetailsImpl user, Pageable pageable);
        Page<Task> findAllByOwnerIdAndTitle(@AuthenticationPrincipal UserDetailsImpl user, String name, Pageable pageable);
}
