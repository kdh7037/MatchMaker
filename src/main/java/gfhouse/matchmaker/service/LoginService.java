package gfhouse.matchmaker.service;

import gfhouse.matchmaker.domain.User;
import gfhouse.matchmaker.repository.LoginRepository;
import gfhouse.matchmaker.repository.UserRepository;
import gfhouse.matchmaker.view.LoginView;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LoginService {
    private final UserRepository userRepository;

    public LoginView login(String userId, String password){
        Optional<User> findUserId = userRepository.findByUserId(userId);
        LoginView loginView = new LoginView();

        User user = findUserId.orElseThrow();
        loginView.setResult(user.getPassword().equals(password));
        return loginView;
    }
}
