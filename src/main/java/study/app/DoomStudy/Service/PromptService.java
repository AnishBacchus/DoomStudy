package study.app.DoomStudy.Service;

import study.app.DoomStudy.Repository.PromptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import study.app.DoomStudy.Classes.Prompt;

import java.util.List;

@Service
public class PromptService {

    @Autowired
    PromptRepository promptRepository;

    //-----------------------------------------------------------------------------------------------------------
    // Method to add prompt.

    public ResponseEntity<String> add(Prompt prompt) {
        promptRepository.save(prompt);
        return ResponseEntity.status(HttpStatus.CREATED).body("Prompt added successfully.");
    }

    //-----------------------------------------------------------------------------------------------------------
    //Method to get all the prompts created.

    public ResponseEntity<List<Prompt>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(promptRepository.findAll());
    }

    //-----------------------------------------------------------------------------------------------------------
    //Method to get a specific question.

    public ResponseEntity<List<Prompt>> getByQuestions(String question) {
        return ResponseEntity.status(HttpStatus.OK).body(promptRepository.findByQuestionContainingIgnoreCase(question));
    }

    //-----------------------------------------------------------------------------------------------------------
    //Method to get a specific answer.

    public ResponseEntity<List<Prompt>> getByAnswer(String answer) {
        return ResponseEntity.status(HttpStatus.OK).body(promptRepository.findByAnswerContainingIgnoreCase(answer));
    }

    //-----------------------------------------------------------------------------------------------------------
    //Method to replace an old question with new question.

    public ResponseEntity<String> updateQues(String current, String newPrompt) {
        List<Prompt> prompts = promptRepository.findByQuestion(current);

        if (prompts.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("Question does not exist");
        }

        Prompt existingPrompt = prompts.get(0);
        existingPrompt.setQuestion(newPrompt);

        return ResponseEntity.status(HttpStatus.OK).body("Question updated.");
    }

    //-----------------------------------------------------------------------------------------------------------
    //Method to replace an old answer with new answer.

    public ResponseEntity<String> updateAns(String current, String newAnswer) {
        List<Prompt> prompts = promptRepository.findByAnswer(current);

        if (prompts.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("Answer does not exist");
        }

        Prompt existingPrompt = prompts.get(0);
        existingPrompt.setAnswer(newAnswer);

        return ResponseEntity.status(HttpStatus.OK).body("Answer updated.");
    }

    //-----------------------------------------------------------------------------------------------------------
    //Method to delete a prompt.

    public ResponseEntity<String> removePrompt(String ans) {
        List<Prompt> prompts = promptRepository.findByAnswer(ans);

        if(prompts.isEmpty()){
            return ResponseEntity.ok("Prompt doesn't exist.");
        }

        promptRepository.delete(prompts.get(0));
        return ResponseEntity.ok("Prompt deleted.");
    }
}
