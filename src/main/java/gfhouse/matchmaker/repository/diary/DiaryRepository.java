package gfhouse.matchmaker.repository.diary;

import gfhouse.matchmaker.domain.diary.Diary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryRepository extends JpaRepository<Diary, Long> {
}
