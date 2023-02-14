package gfhouse.matchmaker.dto;

import gfhouse.matchmaker.domain.User;
import lombok.Builder;
import lombok.Data;

@Data
public class LoginDto {
    private String userId;
    private String password;
}
