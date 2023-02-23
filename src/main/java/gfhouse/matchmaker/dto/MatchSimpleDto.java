package gfhouse.matchmaker.dto;

import gfhouse.matchmaker.domain.User;
import lombok.Builder;
import lombok.Data;

@Data
public class MatchSimpleDto {
    private String player1Nickname;
    private Integer player1Score;
    private String player2Nickname;
    private Integer player2Score;
    private Short status;
}
