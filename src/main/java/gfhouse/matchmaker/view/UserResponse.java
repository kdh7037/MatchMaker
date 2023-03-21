package gfhouse.matchmaker.view;

import gfhouse.matchmaker.dto.UserDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
    private Long id;
    private String userId;
    private String nickname;
    private String password;
    private String email;

    public static UserResponse of(UserDto userDto) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(userDto.getId());
        userResponse.setUserId(userDto.getUserId());
        userResponse.setNickname(userDto.getNickname());
        userResponse.setPassword(userDto.getPassword());
        userResponse.setEmail(userDto.getEmail());

        return userResponse;
    }
}
