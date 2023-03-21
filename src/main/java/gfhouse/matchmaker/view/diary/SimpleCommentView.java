package gfhouse.matchmaker.view.diary;

import gfhouse.matchmaker.domain.diary.Comment;
import lombok.Data;

@Data
public class SimpleCommentView {
    private String author;
    private String contents;

    public static SimpleCommentView of(Comment comment) {
        SimpleCommentView view = new SimpleCommentView();
        view.setAuthor(comment.getAuthor());
        view.setContents(comment.getContents());

        return view;
    }
}
