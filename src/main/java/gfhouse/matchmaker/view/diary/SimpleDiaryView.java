package gfhouse.matchmaker.view.diary;

import gfhouse.matchmaker.domain.diary.Diary;
import lombok.Data;

@Data
public class SimpleDiaryView {
    private Long diaryId;
    private String title;
    private String author;
    private String contents;

    public static SimpleDiaryView of(Diary diary) {
        SimpleDiaryView view = new SimpleDiaryView();
        view.setDiaryId(diary.getId());
        view.setTitle(diary.getTitle());
        view.setAuthor(diary.getAuthor());
        view.setContents(diary.getContents());

        return view;
    }
}
