package gfhouse.matchmaker.service.diary;

import gfhouse.matchmaker.domain.diary.Comment;
import gfhouse.matchmaker.domain.diary.Diary;
import gfhouse.matchmaker.repository.diary.CommentRepository;
import gfhouse.matchmaker.repository.diary.DiaryRepository;
import gfhouse.matchmaker.view.diary.DiaryView;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class DiaryService {

    private final DiaryRepository diaryRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public String saveDiary(String author, String contents, String title) {
        Diary diary = Diary.builder()
                .author(author)
                .contents(contents)
                .title(title)
                .build();

        diaryRepository.save(diary);

        return "ok";
    }

    @Transactional
    public String deleteDiary(Long diaryId) {
        diaryRepository.deleteById(diaryId);

        return "ok";
    }

    @Transactional
    public String saveComment(Long diaryId, String author, String contents) {
        Comment comment = Comment.builder()
                .author(author)
                .contents(contents)
                .build();

        Diary diary = diaryRepository.findById(diaryId).orElseThrow();
        diary.addComment(comment);

        return "ok";
    }

    @Transactional
    public String deleteComment(Long diaryId, Long commentId) {
        commentRepository.deleteByDiary_IdAndId(diaryId, commentId);

        return "ok";
    }

    public DiaryView getDiaryView(Long diaryId) {
        Diary diary = diaryRepository.findFetchById(diaryId).orElseThrow();

        return DiaryView.of(diary, diary.getComments());
    }
}
