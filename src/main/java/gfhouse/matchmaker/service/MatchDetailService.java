package gfhouse.matchmaker.service;

import gfhouse.matchmaker.repository.MatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MatchDetailService {
    private final MatchRepository matchDetailRepository;
/*
    public MatchDetailView login(String userId, String password){
        List<MatchSimpleDto> matchList = matchDetailRepository.findAll();
        MatchDetailView matchDetailView = new MatchDetailView();

        User user = findUserId.orElseThrow();
        loginView.setResult(user.getPassword().equals(password));
        return matchDetailView;
    }*/
}
