package gfhouse.matchmaker.dto;

import gfhouse.matchmaker.domain.User;
import lombok.Builder;
import lombok.Data;

@Data
public class LoginDto {
    private final String nickname;
    private final String password;

    @Builder
    public LoginDto(User user){
        this.nickname = user.getNickname();
        this.password = user.getPassword();
    }
}
