package gfhouse.matchmaker.service;

import gfhouse.matchmaker.domain.Match;
import gfhouse.matchmaker.dto.MatchSimpleDto;
import gfhouse.matchmaker.repository.MatchRepository;
import gfhouse.matchmaker.repository.UserRepository;
import gfhouse.matchmaker.view.MatchDetailView;
import gfhouse.matchmaker.view.MatchSimpleView;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MatchSimpleService {
    private final MatchRepository matchRepository;
    private final List<MatchSimpleDto> matchSimpleDtoList;

    public MatchSimpleView AllMatchInformation(){
        Match match = new Match();
        MatchSimpleView matchSimpleView = new MatchSimpleView();

        matchSimpleView.setMatchSimpleList(matchSimpleDtoList);

        return matchSimpleView;

    }
}
