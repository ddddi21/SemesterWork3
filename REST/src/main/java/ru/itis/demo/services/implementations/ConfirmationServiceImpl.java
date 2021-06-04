package ru.itis.demo.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.demo.models.User;
import ru.itis.demo.repositories.UsersRepositoryInterface;
import ru.itis.demo.services.interfaces.ConfirmationService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConfirmationServiceImpl implements ConfirmationService {
    private final UsersRepositoryInterface usersRepository;
    @Override
    public boolean confirmByCode(String code) {
        Optional<User> userCandidate = usersRepository.findByCurrentConfirmationCode(code);
        if (userCandidate.isPresent()) {
            User user = userCandidate.get();
            if(user.isActive()) throw new IllegalArgumentException("User is already activated");
            user.setState(User.State.ACTIVE);
            usersRepository.save(user);
        }
        return userCandidate.isPresent();
    }
}
