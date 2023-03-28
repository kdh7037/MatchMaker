package gfhouse.matchmaker.service;

import gfhouse.matchmaker.domain.Match;
import gfhouse.matchmaker.dto.MatchSimpleDto;
import gfhouse.matchmaker.repository.MatchRepository;
import gfhouse.matchmaker.repository.UserRepository;
import gfhouse.matchmaker.view.MatchDetailView;
import gfhouse.matchmaker.view.MatchSimpleInfoView;
import gfhouse.matchmaker.view.MatchSimpleView;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MatchSimpleService {
    private final MatchRepository matchRepository;

    public MatchSimpleView getAllMatchInformation(){
        List<Match> matches = matchRepository.findAll();
        List<MatchSimpleInfoView> matchSimpleInfoViews = matches.stream()
                .map(match -> new MatchSimpleInfoView(
                        match.getId(),
                        match.getUser1().getNickname(),
                        match.getUser1().getScore(),
                        match.getUser2().getNickname(),
                        match.getUser2().getScore(),
                        match.getStatus()))
                .collect(Collectors.toList());
        MatchSimpleView matchSimpleView = new MatchSimpleView();
        matchSimpleView.setMatchSimpleInfos(matchSimpleInfoViews);
        return matchSimpleView;
    }
}
