package gfhouse.matchmaker.controller.diary.response;

import gfhouse.matchmaker.domain.diary.Comment;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Schema(description = "댓글 응답")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentResponse {
    @Schema(description = "댓글ID")
    private Long commentId;

    @Schema(description = "댓글 작성자")
    private String author;

    @Schema(description = "댓글 내용")
    private String contents;

    @Schema(description = "작성일자")
    private LocalDateTime createdAt;

    public static CommentResponse of(Comment comment) {
        return new CommentResponse(comment.getId(), comment.getAuthor(), comment.getContents(), comment.getCreatedAt());
    }
}
