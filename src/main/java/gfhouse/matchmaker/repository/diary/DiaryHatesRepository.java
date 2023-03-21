package gfhouse.matchmaker.repository.diary;

import gfhouse.matchmaker.domain.diary.DiaryHates;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DiaryHatesRepository extends JpaRepository<DiaryHates, Long> {
    Optional<DiaryHates> findByDiaryId(Long diaryId);

    Optional<Long> countByDiaryId(Long diaryId);
}
