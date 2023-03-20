package gfhouse.matchmaker.service.diary;

import gfhouse.matchmaker.domain.User;
import gfhouse.matchmaker.domain.diary.Comment;
import gfhouse.matchmaker.domain.diary.Diary;
import gfhouse.matchmaker.domain.diary.DiaryLikes;
import gfhouse.matchmaker.repository.UserRepository;
import gfhouse.matchmaker.repository.diary.CommentRepository;
import gfhouse.matchmaker.repository.diary.DiaryLikesRepository;
import gfhouse.matchmaker.repository.diary.DiaryRepository;
import gfhouse.matchmaker.view.diary.CommentView;
import gfhouse.matchmaker.view.diary.DiaryView;
import gfhouse.matchmaker.view.diary.SimpleDiaryView;
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
    private final UserRepository userRepository;

    @Transactional
    public SimpleDiaryView saveDiary(Long userId, String contents, String title) {
        User user = userRepository.findById(userId).orElseThrow();
        Diary diary = Diary.builder()
                .userId(user.getId())
                .author(user.getNickname())
                .contents(contents)
                .title(title)
                .build();

        Diary saved = diaryRepository.save(diary);
        return SimpleDiaryView.of(saved);
    }

    @Transactional
    public Boolean deleteDiary(Long diaryId, Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        Diary diary = diaryRepository.findById(diaryId).orElseThrow();

        if (!diary.getUserId().equals(user.getId())) {
            throw new IllegalArgumentException("플레이어 일기의 작성자만 일기를 삭제할 수 있습니다.");
        }

        diaryRepository.deleteById(diaryId);

        return true;
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
