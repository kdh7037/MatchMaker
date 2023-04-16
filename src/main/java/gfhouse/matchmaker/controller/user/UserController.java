package gfhouse.matchmaker.controller.user;

import gfhouse.matchmaker.controller.user.request.UserRequest;
import gfhouse.matchmaker.service.user.UserService;
import gfhouse.matchmaker.controller.user.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public UserResponse signup(@RequestBody UserRequest userRequest){
        UserRequest userDto = userService.create(userRequest.getUserId(), userRequest.getNickname(), userRequest.getEmail(), userRequest.getPassword());

        return UserResponse.of(userDto);
    }
}
