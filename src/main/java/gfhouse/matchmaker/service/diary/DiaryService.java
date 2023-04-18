package gfhouse.matchmaker.service.diary;

import gfhouse.matchmaker.domain.user.User;
import gfhouse.matchmaker.domain.diary.Comment;
import gfhouse.matchmaker.domain.diary.Diary;
import gfhouse.matchmaker.domain.diary.DiaryHates;
import gfhouse.matchmaker.domain.diary.DiaryLikes;
import gfhouse.matchmaker.repository.user.UserRepository;
import gfhouse.matchmaker.repository.diary.CommentRepository;
import gfhouse.matchmaker.repository.diary.DiaryHatesRepository;
import gfhouse.matchmaker.repository.diary.DiaryLikesRepository;
import gfhouse.matchmaker.repository.diary.DiaryRepository;
import gfhouse.matchmaker.controller.diary.response.CommentResponse;
import gfhouse.matchmaker.controller.diary.response.DiaryResponse;
import gfhouse.matchmaker.controller.diary.response.SimpleCommentResponse;
import gfhouse.matchmaker.controller.diary.response.SimpleDiaryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    public SimpleDiaryResponse saveDiary(Long userId, String contents, String title) {
        User user = userRepository.findById(userId).orElseThrow();
        Diary diary = Diary.builder()
                .userId(user.getId())
                .author(user.getNickname())
                .contents(contents)
                .title(title)
                .build();

        Diary saved = diaryRepository.save(diary);
        return SimpleDiaryResponse.of(saved);
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
    public SimpleCommentResponse saveComment(Long diaryId, Long userId, String contents) {
        User user = userRepository.findById(userId).orElseThrow();
        Diary diary = diaryRepository.findById(diaryId).orElseThrow();

        Comment comment = Comment.builder()
                .userId(user.getId())
                .author(user.getNickname())
                .contents(contents)
                .build();

        diary.addComment(comment);

        return SimpleCommentResponse.of(comment);
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

    public DiaryResponse getDiaryView(Long diaryId, Long userId) {
        Diary diary = diaryRepository.findFetchById(diaryId).orElseThrow();
        Long likes = diaryLikesRepository.countByDiaryId(diaryId).orElse(0L);
        Long hates = diaryHatesRepository.countByDiaryId(diaryId).orElse(0L);
        List<CommentResponse> commentViews = diary.getComments().stream().map(CommentResponse::of).toList();
        Boolean isLike = null;
        Boolean isHate = null;
        if (userId != null) {
            isLike = diaryLikesRepository.existsByDiaryIdAndUserId(diaryId, userId);
            isHate = diaryHatesRepository.existsByDiaryIdAndUserId(diaryId, userId);
        }

        return DiaryResponse.builder()
                .diaryId(diary.getId())
                .author(diary.getAuthor())
                .title(diary.getTitle())
                .contents(diary.getContents())
                .createdAt(diary.getCreatedAt())
                .likes(likes)
                .hates(hates)
                .comments(commentViews)
                .isLike(isLike)
                .isHate(isHate)
                .build();
    }

    @Transactional
    public boolean likeDiary(Long diaryId, Long userId) {
        validateAlreadyLike(diaryId, userId);
        validateSelfAction(diaryId, userId, "작성자는 좋아요 할 수 없습니다.");

        DiaryLikes diaryLikes = DiaryLikes.builder().diaryId(diaryId).userId(userId).build();
        diaryLikesRepository.save(diaryLikes);

        return true;
    }

    private void validateAlreadyLike(Long diaryId, Long userId) {
        Boolean likeExists = diaryLikesRepository.existsByDiaryIdAndUserId(diaryId, userId);
        if (likeExists) {
            throw new IllegalStateException("이미 좋아요 하였습니다.");
        }
    }

    private void validateSelfAction(Long diaryId, Long userId, String message) {
        Diary diary = diaryRepository.findById(diaryId).orElseThrow();
        if (diary.getUserId().equals(userId)) {
            throw new IllegalArgumentException(message);
        }
    }

    @Transactional
    public boolean hateDiary(Long diaryId, Long userId) {
        validateAlreadyHate(diaryId, userId);
        validateSelfAction(diaryId, userId, "작성자는 싫어요 할 수 없습니다.");

        DiaryHates hates = DiaryHates.builder().diaryId(diaryId).userId(userId).build();
        diaryHatesRepository.save(hates);

        return true;
    }

    private void validateAlreadyHate(Long diaryId, Long userId) {
        Boolean hatesExists = diaryHatesRepository.existsByDiaryIdAndUserId(diaryId, userId);
        if (hatesExists) {
            throw new IllegalStateException("이미 싫어요 하였습니다.");
        }
    }

    public Page<SimpleDiaryResponse> getDiaries(Integer page, Integer size) {
        return diaryRepository.findAll(PageRequest.of(page, size)).map(SimpleDiaryResponse::of);
    }
}
