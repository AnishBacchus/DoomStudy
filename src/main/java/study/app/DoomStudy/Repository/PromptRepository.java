package study.app.DoomStudy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.app.DoomStudy.Prompt;

import java.util.List;

@Repository
public interface PromptRepository extends JpaRepository<Prompt, Long> {
    List<Prompt> findByQuestion(String question);
    List<Prompt> findByAnswer(String answer);
}
