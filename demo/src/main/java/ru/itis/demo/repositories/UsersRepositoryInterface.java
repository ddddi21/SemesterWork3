package ru.itis.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.demo.models.User;

public interface UsersRepositoryInterface extends JpaRepository<User,Long> {
}
