package gfhouse.matchmaker.controller.Score;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ScoreController {
    private final ScoreService scoreService;
}
