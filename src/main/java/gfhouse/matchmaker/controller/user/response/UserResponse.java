package gfhouse.matchmaker.controller.user.response;

import gfhouse.matchmaker.controller.user.request.UserRequest;
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

    public static UserResponse of(UserRequest userRequest) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(userRequest.getId());
        userResponse.setUserId(userRequest.getUserId());
        userResponse.setNickname(userRequest.getNickname());
        userResponse.setPassword(userRequest.getPassword());
        userResponse.setEmail(userRequest.getEmail());

        return userResponse;
    }
}
