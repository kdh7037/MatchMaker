package gfhouse.matchmaker.repository.login;

import gfhouse.matchmaker.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<User, Long> {
}
