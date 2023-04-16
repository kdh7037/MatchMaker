package gfhouse.matchmaker.service.match;

import gfhouse.matchmaker.domain.match.Match;
import gfhouse.matchmaker.repository.match.MatchRepository;
import gfhouse.matchmaker.controller.match.response.MatchSimpleInfoResponse;
import gfhouse.matchmaker.controller.match.response.MatchSimpleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MatchSimpleService {
    private final MatchRepository matchRepository;

    public MatchSimpleResponse getAllMatchInformation(){
        List<Match> matches = matchRepository.findAll();
        List<MatchSimpleInfoResponse> matchSimpleInfoResponses = matches.stream()
                .map(match -> new MatchSimpleInfoResponse(
                        match.getId(),
                        match.getUser1().getNickname(),
                        match.getUser1().getScore(),
                        match.getUser2().getNickname(),
                        match.getUser2().getScore(),
                        match.getStatus()))
                .collect(Collectors.toList());
        MatchSimpleResponse matchSimpleResponse = new MatchSimpleResponse();
        matchSimpleResponse.setMatchSimpleInfos(matchSimpleInfoResponses);
        return matchSimpleResponse;
    }
}
