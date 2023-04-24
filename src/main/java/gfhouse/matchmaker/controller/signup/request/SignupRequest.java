package gfhouse.matchmaker.controller.signup.request;

import lombok.Data;

@Data
public class SignupRequest { //프론트가 보내주는 정보
    private Long id;
    private String userId;
    private String nickname;
    private String password;
    private String email;
}
