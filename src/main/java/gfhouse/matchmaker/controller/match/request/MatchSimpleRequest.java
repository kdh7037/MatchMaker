package gfhouse.matchmaker.controller.match.request;

import gfhouse.matchmaker.domain.user.User;
import lombok.Builder;
import lombok.Data;

@Data
public class MatchSimpleRequest {
    private String player1Nickname;
    private Integer player1Score;
    private String player2Nickname;
    private Integer player2Score;
    private Short status;
}
