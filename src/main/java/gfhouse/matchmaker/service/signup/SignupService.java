package gfhouse.matchmaker.service.signup;

import gfhouse.matchmaker.domain.user.User;
import gfhouse.matchmaker.controller.signup.request.SignupRequest;
import gfhouse.matchmaker.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SignupService {
    private final UserRepository userRepository;

    public SignupRequest create(String userId, String nickname, String email, String password){
        User user = new User();
        user.setUserId(userId);
        user.setNickname(nickname);
        user.setEmail(email);
        user.setPassword(password);
        user.setScore(1500);
        this.userRepository.save(user);

        SignupRequest signupRequest = new SignupRequest();
        signupRequest.setId(user.getId());
        signupRequest.setUserId(user.getUserId());
        signupRequest.setNickname(user.getNickname());
        signupRequest.setEmail(user.getEmail());
        signupRequest.setPassword(user.getPassword());

        return signupRequest;
    }
}
