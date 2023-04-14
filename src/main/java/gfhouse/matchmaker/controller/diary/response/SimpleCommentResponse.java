package gfhouse.matchmaker.controller.diary.response;

import gfhouse.matchmaker.domain.diary.Comment;
import lombok.Data;

@Data
public class SimpleCommentResponse {
    private String author;
    private String contents;

    public static SimpleCommentResponse of(Comment comment) {
        SimpleCommentResponse view = new SimpleCommentResponse();
        view.setAuthor(comment.getAuthor());
        view.setContents(comment.getContents());

        return view;
    }
}
