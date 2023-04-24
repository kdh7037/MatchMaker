package gfhouse.matchmaker.controller.signup;

import gfhouse.matchmaker.controller.signup.request.SignupRequest;
import gfhouse.matchmaker.service.signup.SignupService;
import gfhouse.matchmaker.controller.signup.response.SignupResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class SignupController {
    private final SignupService userService;

    @PostMapping("/signup")
    public SignupResponse signup(@RequestBody SignupRequest signupRequest){
        SignupRequest userDto = userService.create(signupRequest.getUserId(), signupRequest.getNickname(), signupRequest.getEmail(), signupRequest.getPassword());

        return SignupResponse.of(userDto);
    }
}
