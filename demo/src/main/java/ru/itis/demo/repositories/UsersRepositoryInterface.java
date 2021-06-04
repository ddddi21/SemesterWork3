package ru.itis.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.demo.models.User;

import java.util.Optional;

@Repository("userRepository")
public interface UsersRepositoryInterface extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
    Boolean existsByEmail(String email);
    Optional<User> findByCurrentConfirmationCode(String code);
}
