package ru.itis.demo.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.demo.models.Task;

import java.util.List;

@Repository("taskRepository")
public interface TasksRepository extends JpaRepository<Task,Long> {
    Page<Task> findAllByOwnerId(Long id, Pageable pageable);
    Page<Task> findAllByOwnerIdAndTitle(Long id, String name, Pageable pageable);

}
