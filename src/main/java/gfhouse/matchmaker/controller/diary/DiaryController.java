package gfhouse.matchmaker.controller.diary;

import gfhouse.matchmaker.service.diary.DiaryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "플레이어 일기")
@RequiredArgsConstructor
@RestController
@RequestMapping("/diaries")
public class DiaryController {
    private final DiaryService diaryService;

    @PostMapping
    public String saveDiary(
            @RequestParam String author,
            @RequestParam String contents,
            @RequestParam String title
    ) {
        return diaryService.saveDiary(author, contents, title);
    }

    @DeleteMapping("/{diaryId}")
    public String deleteDiary(@PathVariable Long diaryId) {
        return diaryService.deleteDiary(diaryId);
    }

    @PostMapping("/{diaryId}/comments")
    public String saveComment(@PathVariable Long diaryId, @RequestParam String author, @RequestParam String contents) {
        return diaryService.saveComment(diaryId, author, contents);
    }

    @DeleteMapping("/{diaryId}/comments/{commentId}")
    public String deleteComment(@PathVariable Long diaryId, @PathVariable Long commentId) {
        return diaryService.deleteComment(diaryId, commentId);
    }
}
