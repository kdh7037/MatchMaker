package gfhouse.matchmaker.repository;

import gfhouse.matchmaker.domain.Match;
import gfhouse.matchmaker.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Long> {
}
