package gfhouse.matchmaker.controller.match.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MatchSimpleResponse {
    private List<MatchSimpleInfoResponse> matchSimpleInfos;
}

