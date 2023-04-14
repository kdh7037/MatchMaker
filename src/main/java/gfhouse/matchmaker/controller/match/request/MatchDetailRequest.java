package gfhouse.matchmaker.controller.match.request;

import lombok.Data;

@Data
public class MatchDetailRequest {
    private final String opponentNickname;
    private final String opponentScore;
}
