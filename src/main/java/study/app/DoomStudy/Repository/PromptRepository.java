package study.app.DoomStudy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.app.DoomStudy.Classes.Prompt;

import java.util.List;

@Repository
public interface PromptRepository extends JpaRepository<Prompt, Long> {

    List<Prompt> findByQuestionContainingIgnoreCase(String question);
    List<Prompt> findByQuestion(String question);
    List<Prompt> findByAnswerContainingIgnoreCase(String answer);
    List<Prompt> findByAnswer(String answer);
}
