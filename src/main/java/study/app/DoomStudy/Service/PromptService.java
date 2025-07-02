package study.app.DoomStudy.Service;

import study.app.DoomStudy.Classes.UserAccount;
import study.app.DoomStudy.Repository.PromptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import study.app.DoomStudy.Classes.Prompt;

import java.util.List;
import java.util.Optional;

@Service
public class PromptService {

    @Autowired
    PromptRepository promptRepository;

    @Autowired
    UserService userService;

    //-----------------------------------------------------------------------------------------------------------
    // Method to add prompt to user.

    public ResponseEntity<String> addToUser(Long userId, Prompt prompt) {
        Optional<UserAccount> userOpt = userService.findById(userId);
        if (userOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }

        UserAccount user = userOpt.get();
        prompt.setUserAccount(user);
        promptRepository.save(prompt);
        return ResponseEntity.status(HttpStatus.CREATED).body("Prompt added to user.");
    }


    //-----------------------------------------------------------------------------------------------------------
    //Method to get the prompts a user has created.

    public ResponseEntity<List<Prompt>> getAllByUserId(Long userId){
        List<Prompt> prompts = promptRepository.findByUserAccountId(userId);

        if (prompts.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(prompts);
        }
        return ResponseEntity.ok(prompts);
    }


    //-----------------------------------------------------------------------------------------------------------
    //Method to get a specific question.

    public ResponseEntity<List<Prompt>> getByQuestion(Long userId, String question) {
        return ResponseEntity.status(HttpStatus.OK).body(promptRepository.findByUserAccountIdAndQuestion(userId, question));
    }

    //-----------------------------------------------------------------------------------------------------------
    //Method to get a specific answer.

    public ResponseEntity<List<Prompt>> getByAnswer(Long userId, String answer) {
        return ResponseEntity.status(HttpStatus.OK).body(promptRepository.findByUserAccountIdAndAnswer(userId, answer));
    }

    //-----------------------------------------------------------------------------------------------------------
    //Method to replace an old question with new question.

    public ResponseEntity<String> updateQues(Long userId, String current, String newQuestion) {
        List<Prompt> prompts = promptRepository.findByUserAccountIdAndQuestion(userId, current);

        if (prompts.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Question does not exist");
        }

        Prompt existingPrompt = prompts.get(0);
        existingPrompt.setQuestion(newQuestion);
        promptRepository.save(existingPrompt);

        return ResponseEntity.status(HttpStatus.OK).body("Question updated.");
    }

    //-----------------------------------------------------------------------------------------------------------
    //Method to replace an old answer with new answer.

    public ResponseEntity<String> updateAns(Long userId, String current, String newAnswer) {
        List<Prompt> prompts = promptRepository.findByUserAccountIdAndAnswer(userId, current);

        if (prompts.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Answer does not exist");
        }

        Prompt existingPrompt = prompts.get(0);
        existingPrompt.setAnswer(newAnswer);
        promptRepository.save(existingPrompt);

        return ResponseEntity.status(HttpStatus.OK).body("Answer updated.");
    }

    //-----------------------------------------------------------------------------------------------------------
    //Method to delete a prompt.

    public ResponseEntity<String> removePrompt(Long userId, String ans) {
        List<Prompt> prompts = promptRepository.findByUserAccountIdAndAnswer(userId, ans);

        if(prompts.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Prompt doesn't exist.");
        }

        promptRepository.delete(prompts.get(0));
        return ResponseEntity.ok("Prompt deleted.");
    }
}
