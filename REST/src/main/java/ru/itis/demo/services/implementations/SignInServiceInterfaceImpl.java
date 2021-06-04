package ru.itis.demo.services.implementations;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itis.demo.dto.SignInFormDto;
import ru.itis.demo.dto.TokenDto;
import ru.itis.demo.models.User;
import ru.itis.demo.repositories.UsersRepositoryInterface;
import ru.itis.demo.services.interfaces.SignInServiceInterface;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class SignInServiceInterfaceImpl implements SignInServiceInterface {
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private UsersRepositoryInterface usersRepositoryInterface;

    @Value("${jwt.secret}")
    private String secret;

    @Override
    public TokenDto signIn(SignInFormDto formDto) {
        Optional<User> userOptional = usersRepositoryInterface.findByEmail(formDto.getEmail());
        if (userOptional.isPresent()){
            User user = userOptional.get();
            if (passwordEncoder.matches(formDto.getPassword(),user.getPassword())){
                String token = Jwts.builder()
                        .setSubject(user.getId().toString())
                        .claim("email",user.getEmail())
                        .signWith(SignatureAlgorithm.HS256,secret)
                        .compact();
                return new TokenDto(token);
            } else throw new AccessDeniedException("wrong email/password");
        } else throw new AccessDeniedException("User not found");
    }

    @Override
    public Boolean isAvailableUser(SignInFormDto formDto) {
        Optional<User> userOptional = usersRepositoryInterface.findByEmail(formDto.getEmail());
        return userOptional.isPresent() && passwordEncoder.matches(formDto.getPassword(),userOptional.get().getPassword());
    }
}
