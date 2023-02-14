package gfhouse.matchmaker.view;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserView {
    private Long id;
    private String userId;
    private String nickname;
    private String password;
    private String email;
}
