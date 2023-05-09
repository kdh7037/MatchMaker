package gfhouse.matchmaker.controller.signup.response;

import gfhouse.matchmaker.controller.signup.request.SignupRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupResponse {
    private Long id;
    private String userId;
    private String nickname;
    private String email;

    public static SignupResponse of(SignupRequest signupRequest) {
        SignupResponse signupResponse = new SignupResponse();
        signupResponse.setId(signupRequest.getId());
        signupResponse.setUserId(signupRequest.getUserId());
        signupResponse.setNickname(signupRequest.getNickname());
        signupResponse.setEmail(signupRequest.getEmail());

        return signupResponse;
    }
}
