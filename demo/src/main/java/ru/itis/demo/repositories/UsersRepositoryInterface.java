package ru.itis.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.demo.models.User;

@Repository("userRepository")
public interface UsersRepositoryInterface extends JpaRepository<User,Long> {
    User findByEmail(String email);
    Boolean existsByEmail(String email);
}
