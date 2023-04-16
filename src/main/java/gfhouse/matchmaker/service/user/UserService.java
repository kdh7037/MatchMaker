package gfhouse.matchmaker.service.user;

import gfhouse.matchmaker.domain.user.User;
import gfhouse.matchmaker.controller.user.request.UserRequest;
import gfhouse.matchmaker.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserRequest create(String userId, String nickname, String email, String password){
        User user = new User();
        user.setUserId(userId);
        user.setNickname(nickname);
        user.setEmail(email);
        user.setPassword(password);
        user.setScore(1500);
        this.userRepository.save(user);

        UserRequest userRequest = new UserRequest();
        userRequest.setId(user.getId());
        userRequest.setUserId(user.getUserId());
        userRequest.setNickname(user.getNickname());
        userRequest.setEmail(user.getEmail());
        userRequest.setPassword(user.getPassword());

        return userRequest;
    }
}
