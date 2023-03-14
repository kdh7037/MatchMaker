package gfhouse.matchmaker.dto;

import lombok.Data;

@Data
public class UserRequest { // 프론트가 보내주는 정보?
    private String userId;
    private String nickname;
    private String password;
    private String email;
}
