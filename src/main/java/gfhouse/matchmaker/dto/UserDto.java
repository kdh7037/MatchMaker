package gfhouse.matchmaker.dto;

import gfhouse.matchmaker.domain.User;
import lombok.Builder;
import lombok.Data;

@Data
public class UserDto { // 프론트가 보내주는 정보?
    private String userId;
    private String nickname;
    private String password;
    private String email;
}
