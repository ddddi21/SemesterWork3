package ru.itis.demo.security.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.itis.demo.models.User;
import ru.itis.demo.repositories.UsersRepositoryInterface;

@Component("customUserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersRepositoryInterface usersRepositoryInterface;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = usersRepositoryInterface.findByEmail(s)
                .orElseThrow(()-> new UsernameNotFoundException("User not found"));
                return new UserDetailsImpl(user);
    }
}
