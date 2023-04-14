package gfhouse.matchmaker.service.login;

import gfhouse.matchmaker.domain.user.User;
import gfhouse.matchmaker.repository.user.UserRepository;
import gfhouse.matchmaker.controller.login.response.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LoginService {
    private final UserRepository userRepository;

    public LoginResponse login(String userId, String password){
        Optional<User> findUserId = userRepository.findByUserId(userId);
        LoginResponse loginResponse = new LoginResponse();

        User user = findUserId.orElseThrow();
        loginResponse.setResult(user.getPassword().equals(password));
        return loginResponse;
    }
}
