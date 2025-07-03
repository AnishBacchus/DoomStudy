package study.app.DoomStudy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.app.DoomStudy.Classes.Prompt;
import java.util.List;

@Repository
public interface PromptRepository extends JpaRepository<Prompt, Long> {

    List<Prompt> findByUserAccountId(Long userId);
    List<Prompt> findByUserAccountIdAndQuestion(Long userId, String question);
    List<Prompt> findByUserAccountIdAndAnswer(Long userId, String answer);
 }
