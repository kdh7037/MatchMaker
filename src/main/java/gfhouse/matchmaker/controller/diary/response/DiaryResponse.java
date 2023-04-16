package gfhouse.matchmaker.controller.diary.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Schema(description = "일기 단건조회 응답")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DiaryResponse {
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
    private List<CommentResponse> comments = Collections.emptyList();

    @Schema(description = "좋아요 여부", nullable = true)
    private Boolean isLike;

    @Schema(description = "싫어요 여부", nullable = true)
    private Boolean isHate;
}
