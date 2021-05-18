package ru.itis.demo.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.itis.demo.dto.TasksPageDto;
import ru.itis.demo.models.Task;
import ru.itis.demo.models.User;
import ru.itis.demo.repositories.TasksRepository;
import ru.itis.demo.repositories.UsersRepositoryInterface;
import ru.itis.demo.security.details.UserDetailsImpl;
import ru.itis.demo.services.interfaces.AllTasksInterface;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AllTasksInterfaceImpl implements AllTasksInterface {
    @Autowired
    private TasksRepository tasksRepository;

    @Autowired
    private UsersRepositoryInterface usersRepositoryInterface;
    @Override
    public Page<Task> findAllTask(UserDetailsImpl userDetails, Pageable pageable) {
        User user = usersRepositoryInterface.findByEmail(userDetails.getUsername()).get();
        return tasksRepository.findAllByOwnerId(user.getId(), pageable);
    }

    @Override
    public Page<Task> findAllByOwnerIdAndTitle(UserDetailsImpl userDetails, String name, Pageable pageable) {
        User user = usersRepositoryInterface.findByEmail(userDetails.getUsername()).get();
        return tasksRepository.findAllByOwnerIdAndTitle(user.getId(), name, pageable);
    }
}
