package gfhouse.matchmaker.repository.diary;

import gfhouse.matchmaker.domain.diary.Diary;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DiaryRepository extends JpaRepository<Diary, Long> {
    @EntityGraph(attributePaths = "comments")
    Optional<Diary> findFetchById(Long id);
}
