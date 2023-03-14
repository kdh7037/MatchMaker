package gfhouse.matchmaker.controller;

import gfhouse.matchmaker.dto.LoginDto;
import gfhouse.matchmaker.dto.MatchSimpleDto;
import gfhouse.matchmaker.service.LoginService;
import gfhouse.matchmaker.service.MatchSimpleService;
import gfhouse.matchmaker.view.LoginView;
import gfhouse.matchmaker.view.MatchSimpleView;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MatchController {
    private final MatchSimpleService matchSimpleService;

    @GetMapping("/simple")
    public MatchSimpleView getSimplematchInformation(){
        return matchSimpleService.getAllMatchInformation();
    }
}
