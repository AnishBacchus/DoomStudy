package study.app.DoomStudy.controller;

import org.springframework.http.ResponseEntity;
import study.app.DoomStudy.Service.PromptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import study.app.DoomStudy.Classes.Prompt;

import java.util.List;

@RestController
@RequestMapping("/users")
public class PromptController {

    @Autowired
    PromptService promptService;


    //-----------------------------------------------------------------------------------------------------------
    // Method to add prompt to user.

    @PostMapping("/{userId}/add")
    public ResponseEntity<String> addPromptForUser(@PathVariable Long userId, @RequestBody Prompt prompt) {
        return promptService.addToUser(userId, prompt);
    }

    //-----------------------------------------------------------------------------------------------------------
    //Method to get all the prompts created.

    @GetMapping("/{userId}/prompts")
    public ResponseEntity<List<Prompt>> getPrompts(@PathVariable Long userId) { //Status 200
        return promptService.getAllByUserId(userId);
    }

    //-----------------------------------------------------------------------------------------------------------
    //Method to get a specific question.

    @GetMapping("/{userId}/getQuestion/{question}")
    public ResponseEntity<List<Prompt>> getQuestion(@PathVariable Long userId, @PathVariable String question) { //Status 200
        return promptService.getByQuestion(userId, question);
    }

    //-----------------------------------------------------------------------------------------------------------
    //Method to get a specific question.

    @GetMapping("/{userId}/getAnswer/{answer}")
    public ResponseEntity<List<Prompt>> getAnswer(@PathVariable Long userId, @PathVariable String answer) { //Status 200
        return promptService.getByAnswer(userId, answer);
    }

    //-----------------------------------------------------------------------------------------------------------
    //Method to replace an old question with new question. FIX METHOD

    @PutMapping("/{userId}/replaceQuestion/{current}/{new}")
    public ResponseEntity<String> updateQuestion(@PathVariable Long userId, @PathVariable String current, @PathVariable String newQuestion) { //Status 200
        return promptService.updateQues(userId,current, newQuestion);
    }

    //-----------------------------------------------------------------------------------------------------------
    //Method to replace an old answer with new answer. FIX METHOD

    @PutMapping("/{userId}/replaceAnswer/{current}/{new}")
    public ResponseEntity<String> updateAnswer(@PathVariable Long userId, @PathVariable String current, @PathVariable String newAnswer) { //Status 200
        return promptService.updateAns(userId, current, newAnswer);
    }

    //-----------------------------------------------------------------------------------------------------------
    //Method to delete a prompt.

    @DeleteMapping("/{userId}/remove/{prompt}")
    public ResponseEntity<String> removePrompt(@ PathVariable Long userId, @PathVariable String prompt) { //Status 204
        return promptService.removePrompt(userId, prompt);
    }

}
