package gfhouse.matchmaker.controller.login;

import gfhouse.matchmaker.controller.login.request.LoginRequest;
import gfhouse.matchmaker.service.login.LoginService;
import gfhouse.matchmaker.controller.login.response.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LoginController {
    private final LoginService loginService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest){
        return loginService.login(loginRequest.getUserId(), loginRequest.getPassword());
    }
}