package Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.app.DoomStudy.Prompt;

import java.util.List;

public interface PromptRepository extends JpaRepository<Prompt, String> {
    List<Prompt> findByQuestion(String question);
    List<Prompt> findByAnswer(String answer);
}
