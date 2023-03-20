package gfhouse.matchmaker.service.diary;

import gfhouse.matchmaker.domain.User;
import gfhouse.matchmaker.domain.diary.Comment;
import gfhouse.matchmaker.domain.diary.Diary;
import gfhouse.matchmaker.domain.diary.DiaryHates;
import gfhouse.matchmaker.domain.diary.DiaryLikes;
import gfhouse.matchmaker.repository.UserRepository;
import gfhouse.matchmaker.repository.diary.CommentRepository;
import gfhouse.matchmaker.repository.diary.DiaryHatesRepository;
import gfhouse.matchmaker.repository.diary.DiaryLikesRepository;
import gfhouse.matchmaker.repository.diary.DiaryRepository;
import gfhouse.matchmaker.view.diary.CommentView;
import gfhouse.matchmaker.view.diary.DiaryView;
import gfhouse.matchmaker.view.diary.SimpleCommentView;
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
    private final DiaryHatesRepository diaryHatesRepository;
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
    public SimpleCommentView saveComment(Long diaryId, Long userId, String contents) {
        User user = userRepository.findById(userId).orElseThrow();
        Diary diary = diaryRepository.findById(diaryId).orElseThrow();

        Comment comment = Comment.builder()
                .userId(user.getId())
                .author(user.getNickname())
                .contents(contents)
                .build();

        diary.addComment(comment);

        return SimpleCommentView.of(comment);
    }

    @Transactional
    public Boolean deleteComment(Long diaryId, Long commentId, Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        Diary diary = diaryRepository.findById(diaryId).orElseThrow();
        Comment comment = commentRepository.findById(commentId).orElseThrow();

        validateComment(user, diary, comment);

        commentRepository.delete(comment);
        return true;
    }

    private void validateComment(User user, Diary diary, Comment comment) {
        Long diaryId = comment.getDiary().getId();
        if (!diaryId.equals(diary.getId())) {
            throw new IllegalArgumentException("잘못된 요청입니다.");
        }

        Long userId = comment.getUserId();
        if (!userId.equals(user.getId())) {
            throw new IllegalArgumentException("작성자만 댓글을 삭제할 수 있습니다.");
        }
    }

    public DiaryView getDiaryView(Long diaryId) {
        Diary diary = diaryRepository.findFetchById(diaryId).orElseThrow();
        Long likes = diaryLikesRepository.countByDiaryId(diaryId).orElse(0L);
        Long hates = diaryHatesRepository.countByDiaryId(diaryId).orElse(0L);
        List<CommentView> commentViews = diary.getComments().stream().map(CommentView::of).toList();

        return DiaryView.builder()
                .diaryId(diary.getId())
                .author(diary.getAuthor())
                .title(diary.getTitle())
                .contents(diary.getContents())
                .createdAt(diary.getCreatedAt())
                .likes(likes)
                .hates(hates)
                .comments(commentViews)
                .build();
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

    @Transactional
    public boolean hateDiary(Long diaryId, Long userId) {
        boolean present = diaryHatesRepository.findByDiaryId(diaryId).isPresent();
        if (present) return false;

        DiaryHates hates = DiaryHates.builder().diaryId(diaryId).userId(userId).build();
        diaryHatesRepository.save(hates);

        return true;
    }
}
