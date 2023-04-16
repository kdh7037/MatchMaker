package gfhouse.matchmaker.controller.login.request;

import gfhouse.matchmaker.domain.user.User;
import lombok.Builder;
import lombok.Data;

@Data
public class LoginRequest {
    private String userId;
    private String password;
}

