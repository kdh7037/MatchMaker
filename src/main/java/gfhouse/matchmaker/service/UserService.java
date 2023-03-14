package gfhouse.matchmaker.service;

import gfhouse.matchmaker.domain.User;
import gfhouse.matchmaker.dto.UserDto;
import gfhouse.matchmaker.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserDto create(String userId, String nickname, String email, String password){
        User user = new User();
        user.setUserId(userId);
        user.setNickname(nickname);
        user.setEmail(email);
        user.setPassword(password);
        user.setScore(1500);
        this.userRepository.save(user);

        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUserId(user.getUserId());
        userDto.setNickname(user.getNickname());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());

        return userDto;
    }
}
