package study.app.DoomStudy.controller;

import org.springframework.http.ResponseEntity;
import study.app.DoomStudy.Classes.UserAccount;
import study.app.DoomStudy.Service.PromptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import study.app.DoomStudy.Classes.Prompt;
import study.app.DoomStudy.Service.UserService;

import java.util.List;

@RestController
public class StudyController {

    @Autowired
    PromptService promptService;

    @Autowired
    UserService userService;

    //-----------------------------------------------------------------------------------------------------------
    // Method to add prompt.

    @PostMapping("/new")
    public ResponseEntity<String> addPrompt(@RequestBody Prompt prompt) { //Status 201
        return promptService.add(prompt);
    }

    //-----------------------------------------------------------------------------------------------------------
    // Method to add user.

    @PostMapping("/create")
    public ResponseEntity<String> addUser(@RequestBody UserAccount userAccount) { //Status 201
        return userService.create(userAccount);
    }

    //-----------------------------------------------------------------------------------------------------------
    //Method to get all the prompts created.

    @GetMapping("/get")
    public ResponseEntity<List<Prompt>> getPrompt() { //Status 200
        return promptService.getAll();
    }

    //-----------------------------------------------------------------------------------------------------------
    //Method to get a specific question.

    @GetMapping("/questions/{question}")
    public ResponseEntity<List<Prompt>> getQuestion(@PathVariable String question) { //Status 200
        return promptService.getByQuestions(question);
    }

    //-----------------------------------------------------------------------------------------------------------
    //Method to get a specific question.

    @GetMapping("/answers/{answer}")
    public ResponseEntity<List<Prompt>> getAnswer(@PathVariable String answer) { //Status 200
        return promptService.getByAnswer(answer);
    }

    //-----------------------------------------------------------------------------------------------------------
    //Method to replace an old question with new question.

    @PutMapping("/replaceQuestion/{current}/{new}")
    public ResponseEntity<String> updateQuestion(@PathVariable String current, @PathVariable String newQuestion) { //Status 200
        return promptService.updateQues(current, newQuestion);
    }

    //-----------------------------------------------------------------------------------------------------------
    //Method to replace an old answer with new answer.

    @PutMapping("/replaceAnswer/{current}/{new}")
    public ResponseEntity<String> updateAnswer(@PathVariable String current, @PathVariable String newAnswer) { //Status 200
        return promptService.updateAns(current, newAnswer);
    }

    //-----------------------------------------------------------------------------------------------------------
    //Method to delete a prompt.

    @DeleteMapping("/remove/{prompt}")
    public ResponseEntity<String> removePrompt(@PathVariable String prompt) { //Status 204
        return promptService.removePrompt(prompt);
    }

}
