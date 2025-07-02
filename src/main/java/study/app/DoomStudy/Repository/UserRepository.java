package study.app.DoomStudy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.app.DoomStudy.Classes.UserAccount;
import java.util.*;

public interface UserRepository extends JpaRepository<UserAccount, Long> {
    List<UserAccount> findByUsername(String username);
}
