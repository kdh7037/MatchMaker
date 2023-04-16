package gfhouse.matchmaker.controller.match.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MatchSimpleInfoResponse {
    private Long id;
    private String player1Nickname;
    private Integer player1Score;
    private String player2Nickname;
    private Integer player2Score;
    private Character status;

    public MatchSimpleInfoResponse(Long id, String player1Nickname, Integer player1Score, String player2Nickname, Integer player2Score, Character status) {
        this.id = id;
        this.player1Nickname = player1Nickname;
        this.player1Score = player1Score;
        this.player2Nickname = player2Nickname;
        this.player2Score = player2Score;
        this.status = status;
    }
}
