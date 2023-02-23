package gfhouse.matchmaker.controller.diary;

import gfhouse.matchmaker.service.diary.DiaryService;
import gfhouse.matchmaker.view.diary.DiaryView;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "플레이어 일기")
@RequiredArgsConstructor
@RestController
@RequestMapping("/diaries")
public class DiaryController {
    private final DiaryService diaryService;

    @Operation(summary = "플레이어 일기 작성")
    @PostMapping
    public String saveDiary(
            @Parameter(description = "작성자") @RequestParam String author,
            @Parameter(description = "제목") @RequestParam String title,
            @Parameter(description = "본문") @RequestParam String contents
    ) {
        return diaryService.saveDiary(author, contents, title);
    }

    @Operation(summary = "플레이어 일기 삭제")
    @DeleteMapping("/{diaryId}")
    public String deleteDiary(@Parameter(description = "일기ID") @PathVariable Long diaryId) {
        return diaryService.deleteDiary(diaryId);
    }

    @Operation(summary = "플레이어 일기 댓글 작성")
    @PostMapping("/{diaryId}/comments")
    public String saveComment(
            @Parameter(description = "일기ID") @PathVariable Long diaryId,
            @Parameter(description = "작성자") @RequestParam String author,
            @Parameter(description = "댓글 내용") @RequestParam String contents
    ) {
        return diaryService.saveComment(diaryId, author, contents);
    }

    @Operation(summary = "플레이어 일기 댓글 삭제")
    @DeleteMapping("/{diaryId}/comments/{commentId}")
    public String deleteComment(
            @Parameter(description = "일기ID") @PathVariable Long diaryId,
            @Parameter(description = "댓글ID") @PathVariable Long commentId
    ) {
        return diaryService.deleteComment(diaryId, commentId);
    }

    @Operation(summary = "플레이어 일기 조회")
    @GetMapping("/{diaryId}")
    public DiaryView getDiary(@Parameter(description = "일기ID") @PathVariable Long diaryId) {
        return diaryService.getDiaryView(diaryId);
    }
}
