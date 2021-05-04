package ru.itis.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.demo.models.Task;

@Repository("taskRepository")
public interface TasksRepository extends JpaRepository<Task,Long> {
}
