package gfhouse.matchmaker.repository.match;

import gfhouse.matchmaker.domain.match.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Long> {
}
