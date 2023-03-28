package gfhouse.matchmaker.controller;

import gfhouse.matchmaker.dto.UserDto;
import gfhouse.matchmaker.dto.UserRequest;
import gfhouse.matchmaker.service.UserService;
import gfhouse.matchmaker.view.UserResponse;
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
        UserDto userDto = userService.create(userRequest.getUserId(), userRequest.getNickname(), userRequest.getEmail(), userRequest.getPassword());

        return UserResponse.of(userDto);
    }
}
