package gfhouse.matchmaker.view.diary;

import gfhouse.matchmaker.domain.diary.Comment;
import gfhouse.matchmaker.domain.diary.Diary;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Schema(description = "일기 단건조회 응답")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DiaryView {
    @Schema(description = "일기ID")
    private Long diaryId;

    @Schema(description = "작성자")
    private String author;

    @Schema(description = "제목")
    private String title;

    @Schema(description = "본문")
    private String contents;

    @Schema(description = "좋아요 수")
    private Long likes;

    @Schema(description = "싫어요 수")
    private Long hates;

    @Schema(description = "작성일자")
    private LocalDateTime createdAt;

    @Schema(description = "댓글 목록")
    private List<CommentView> comments = Collections.emptyList();

    public static DiaryView of(Diary diary, List<Comment> comments) {
        List<CommentView> commentViews = comments.stream().map(CommentView::of).toList();
        return new DiaryView(
                diary.getId(), diary.getAuthor(), diary.getTitle(), diary.getContents(),
                diary.getLikes(), diary.getHates(), diary.getCreatedAt(), commentViews
        );
    }
}

@Schema(description = "댓글 응답")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class CommentView {
    @Schema(description = "댓글ID")
    private Long commentId;

    @Schema(description = "댓글 작성자")
    private String author;

    @Schema(description = "댓글 내용")
    private String contents;

    @Schema(description = "작성일자")
    private LocalDateTime createdAt;

    public static CommentView of(Comment comment) {
        return new CommentView(comment.getId(), comment.getAuthor(), comment.getContents(), comment.getCreatedAt());
    }
}
