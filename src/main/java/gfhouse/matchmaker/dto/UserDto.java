package gfhouse.matchmaker.dto;

import gfhouse.matchmaker.domain.User;
import lombok.Builder;
import lombok.Data;

@Data
public class UserDto {
    private final String nickname;
    private final String password;
    private final String email;

    @Builder
    public UserDto(User user){
        this.nickname = user.getNickname();
        this.password = user.getPassword();
        this.email = user.getEmail();
    }
}
