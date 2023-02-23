package gfhouse.matchmaker.view.diary;

import gfhouse.matchmaker.domain.diary.Comment;
import gfhouse.matchmaker.domain.diary.Diary;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DiaryView {
    private Long diaryId;
    private String author;
    private String title;
    private String contents;
    private Long likes;
    private Long hates;
    private LocalDateTime createdAt;
    private List<CommentView> comments = Collections.emptyList();

    public static DiaryView of(Diary diary, List<Comment> comments) {
        List<CommentView> commentViews = comments.stream().map(CommentView::of).toList();
        return new DiaryView(
                diary.getId(), diary.getAuthor(), diary.getTitle(), diary.getContents(),
                diary.getLikes(), diary.getHates(), diary.getCreatedAt(), commentViews
        );
    }
}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class CommentView {
    private Long commentId;
    private String author;
    private String contents;
    private LocalDateTime createdAt;

    public static CommentView of(Comment comment) {
        return new CommentView(comment.getId(), comment.getAuthor(), comment.getContents(), comment.getCreatedAt());
    }
}
