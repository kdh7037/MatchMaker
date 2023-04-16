package gfhouse.matchmaker.controller.diary.response;

import gfhouse.matchmaker.domain.diary.Diary;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SimpleDiaryResponse {
    private Long diaryId;
    private String title;
    private String author;
    private String contents;
    private LocalDateTime createdAt;

    public static SimpleDiaryResponse of(Diary diary) {
        SimpleDiaryResponse view = new SimpleDiaryResponse();
        view.setDiaryId(diary.getId());
        view.setTitle(diary.getTitle());
        view.setAuthor(diary.getAuthor());
        view.setContents(diary.getContents());
        view.setCreatedAt(diary.getCreatedAt());

        return view;
    }
}
