package gfhouse.matchmaker.controller.match;

import gfhouse.matchmaker.service.match.MatchSimpleService;
import gfhouse.matchmaker.controller.match.response.MatchSimpleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MatchController {
    private final MatchSimpleService matchSimpleService;

    @GetMapping("/simple")
    public MatchSimpleResponse (){
        return matchSimpleService.getAllMatchInformation();
    }getSimplematchInformation

    @GetMapping("/")
    public MatchDetailResponse
}
