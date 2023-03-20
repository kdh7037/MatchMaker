package gfhouse.matchmaker.service.diary;

import gfhouse.matchmaker.domain.diary.Comment;
import gfhouse.matchmaker.domain.diary.Diary;
import gfhouse.matchmaker.domain.diary.DiaryLikes;
import gfhouse.matchmaker.repository.diary.CommentRepository;
import gfhouse.matchmaker.repository.diary.DiaryLikesRepository;
import gfhouse.matchmaker.repository.diary.DiaryRepository;
import gfhouse.matchmaker.view.diary.CommentView;
import gfhouse.matchmaker.view.diary.DiaryView;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class DiaryService {

    private final DiaryRepository diaryRepository;
    private final CommentRepository commentRepository;
    private final DiaryLikesRepository diaryLikesRepository;

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

    public DiaryView getDiaryView(Long diaryId,  Long userId) {
        Diary diary = diaryRepository.findFetchById(diaryId).orElseThrow();
        Long likes = getLikes(userId);
        List<CommentView> commentViews = diary.getComments().stream().map(CommentView::of).toList();

        return DiaryView.builder()
                .diaryId(diary.getId())
                .author(diary.getAuthor())
                .title(diary.getTitle())
                .contents(diary.getContents())
                .createdAt(diary.getCreatedAt())
                .likes(likes)
                .comments(commentViews)
                .build();
    }

    private Long getLikes(Long userId) {
        if (userId == null) return 0L;

        return diaryLikesRepository.countByUserId(userId);
    }

    @Transactional
    public boolean likeDiary(Long diaryId, Long userId) {
        boolean isPresent = diaryLikesRepository.findByDiaryId(diaryId).isPresent();
        if (isPresent) return false;

        DiaryLikes diaryLikes = DiaryLikes.builder()
                .diaryId(diaryId)
                .userId(userId)
                .build();

        diaryLikesRepository.save(diaryLikes);
        return true;
    }
}
