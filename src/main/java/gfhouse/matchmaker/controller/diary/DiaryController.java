package gfhouse.matchmaker.controller.diary;

import gfhouse.matchmaker.service.diary.DiaryService;
import gfhouse.matchmaker.view.BooleanView;
import gfhouse.matchmaker.view.diary.DiaryView;
import gfhouse.matchmaker.view.diary.SimpleCommentView;
import gfhouse.matchmaker.view.diary.SimpleDiaryView;
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
    public SimpleDiaryView saveDiary(
            @Parameter(description = "유저ID") @RequestParam Long userId,
            @Parameter(description = "제목") @RequestParam String title,
            @Parameter(description = "본문") @RequestParam String contents
    ) {
        return diaryService.saveDiary(userId, contents, title);
    }

    @Operation(summary = "플레이어 일기 삭제")
    @DeleteMapping("/{diaryId}")
    public BooleanView deleteDiary(
            @Parameter(description = "일기ID") @PathVariable Long diaryId,
            @Parameter(description = "유저ID") @RequestParam Long userId
    ) {
        Boolean result = diaryService.deleteDiary(diaryId, userId);
        return BooleanView.of(result);
    }

    @Operation(summary = "플레이어 일기 댓글 작성")
    @PostMapping("/{diaryId}/comments")
    public SimpleCommentView saveComment(
            @Parameter(description = "일기ID") @PathVariable Long diaryId,
            @Parameter(description = "유저ID") @RequestParam Long userId,
            @Parameter(description = "댓글 내용") @RequestParam String contents
    ) {
        return diaryService.saveComment(diaryId, userId, contents);
    }

    @Operation(summary = "플레이어 일기 댓글 삭제")
    @DeleteMapping("/{diaryId}/comments/{commentId}")
    public BooleanView deleteComment(
            @Parameter(description = "일기ID") @PathVariable Long diaryId,
            @Parameter(description = "댓글ID") @PathVariable Long commentId,
            @Parameter(description = "유저ID") @RequestParam Long userId
    ) {
        Boolean result = diaryService.deleteComment(diaryId, commentId, userId);
        return BooleanView.of(result);
    }

    @Operation(summary = "플레이어 일기 조회")
    @GetMapping("/{diaryId}")
    public DiaryView getDiary(@Parameter(description = "일기ID") @PathVariable Long diaryId) {
        return diaryService.getDiaryView(diaryId);
    }

    @Operation(summary = "플레이어 일기 좋아요")
    @PostMapping("/likes")
    public BooleanView likeDiary(@RequestParam Long diaryId, @RequestParam Long userId) {
        boolean result = diaryService.likeDiary(diaryId, userId);
        return BooleanView.of(result);
    }

    @Operation(summary = "플레이어 일기 싫어요")
    @PostMapping("/hates")
    public BooleanView hateDiary(@RequestParam Long diaryId, @RequestParam Long userId) {
        boolean result = diaryService.hateDiary(diaryId, userId);
        return BooleanView.of(result);
    }
}
