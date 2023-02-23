package gfhouse.matchmaker.repository.diary;

import gfhouse.matchmaker.domain.diary.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
