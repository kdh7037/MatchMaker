package gfhouse.matchmaker.repository;

import gfhouse.matchmaker.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<User, Long> {
}
