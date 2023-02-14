package gfhouse.matchmaker.controller;

import gfhouse.matchmaker.domain.User;
import gfhouse.matchmaker.dto.UserDto;
import gfhouse.matchmaker.service.UserService;
import gfhouse.matchmaker.view.UserView;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public UserView signup(@RequestBody UserDto userDto){
        return userService.create(userDto.getUserId(), userDto.getNickname(), userDto.getEmail(), userDto.getPassword());
    }
}
