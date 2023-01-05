/*package gfhouse.matchmaker.service;

import gfhouse.matchmaker.domain.User;
import gfhouse.matchmaker.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public User create(String username, String email, String password){
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(password));
        this.userRepository.save(user);
        return user;
    }
}*/