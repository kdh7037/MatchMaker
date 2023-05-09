package gfhouse.matchmaker.service.match;

import gfhouse.matchmaker.controller.match.response.MatchDetailResponse;
import gfhouse.matchmaker.repository.match.MatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MatchDetailService {
    private final MatchRepository matchRepository;
    public MatchDetailResponse getMatchInformation(){
        List<MatchSimpleDto> matchList = matchDetailRepository.findAll();
        MatchDetailView matchDetailView = new MatchDetailView();

        User user = findUserId.orElseThrow();
        loginView.setResult(user.getPassword().equals(password));
        return matchDetailResponse;
    }
}
