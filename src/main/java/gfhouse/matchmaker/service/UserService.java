package gfhouse.matchmaker.service;

import gfhouse.matchmaker.domain.User;
import gfhouse.matchmaker.repository.UserRepository;
import gfhouse.matchmaker.view.UserView;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserView create(String userId, String nickname, String email, String password){
        User user = new User();
        user.setUserId(userId);
        user.setNickname(nickname);
        user.setEmail(email);
        user.setPassword(password);
        this.userRepository.save(user);

        UserView userView = new UserView();
        userView.setUserId(userId);
        userView.setNickname(nickname);
        userView.setEmail(email);
        return userView;
    }
}