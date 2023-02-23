package gfhouse.matchmaker.view;

import gfhouse.matchmaker.domain.Match;
import gfhouse.matchmaker.dto.MatchSimpleDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MatchSimpleView {
    private List<MatchSimpleDto> matchSimpleList;
}
