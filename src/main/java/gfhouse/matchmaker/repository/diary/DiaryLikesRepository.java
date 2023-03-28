package gfhouse.matchmaker.repository.diary;

import gfhouse.matchmaker.domain.diary.DiaryLikes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DiaryLikesRepository extends JpaRepository<DiaryLikes, Long> {

    Optional<DiaryLikes> findByDiaryId(Long diaryId);

    Optional<Long> countByDiaryId(Long diaryId);
}
