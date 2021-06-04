package ru.itis.demo.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.demo.models.Task;

import java.util.List;
import java.util.Optional;

@Repository("taskRepository")
public interface TasksRepository extends JpaRepository<Task,Long> {
    List<Task> findAllByOwnerId(Long id);
    List<Task> findAllByOwnerIdAndTitle(Long id, String name);
    Optional<Task> findById(Long id);
    List<Task> findAllByIsAvailableFalse();
}
