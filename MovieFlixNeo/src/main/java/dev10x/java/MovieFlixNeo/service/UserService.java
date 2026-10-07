package dev10x.java.MovieFlixNeo.service;

import dev10x.java.MovieFlixNeo.entity.User;
import dev10x.java.MovieFlixNeo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public User save(User user) {
        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));

        return userRepository.save(user);
    }

}
