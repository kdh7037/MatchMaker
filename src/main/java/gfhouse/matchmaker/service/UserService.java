package gfhouse.matchmaker.service;

import gfhouse.matchmaker.domain.User;
import gfhouse.matchmaker.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public User create(String nickname, String email, String password){
        User user = new User();
        user.setNickname(nickname);
        user.setEmail(email);
        user.setPassword(password);
        this.userRepository.save(user);
        return user;
    }
}