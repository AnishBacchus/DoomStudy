package study.app.DoomStudy.controller;

import org.springframework.http.ResponseEntity;
import study.app.DoomStudy.Service.PromptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import study.app.DoomStudy.Prompt;

import java.util.List;

@RestController
public class StudyController {

    @Autowired
    PromptService promptService;

    //-----------------------------------------------------------------------------------------------------------
    // Method to add prompt.

    @PostMapping("/new")
    public ResponseEntity<String> addPrompt(@RequestBody Prompt prompt) { //Status 201
        return promptService.add(prompt);
    }
    //-----------------------------------------------------------------------------------------------------------
    //Method to get all the prompts created.

    @GetMapping("/get")
    public ResponseEntity<List<Prompt>> getPrompt() { //Status 200
        return promptService.get();
    }



    //-----------------------------------------------------------------------------------------------------------
    //Method to replace an old prompt with new prompt.

    @PutMapping("/replace/{current}")
    public void updatePrompt(@PathVariable String current) { //Status 200

    }

    //-----------------------------------------------------------------------------------------------------------
    //Method to delete a prompt.

    @DeleteMapping("/remove/{prompt}")
    public void removePrompt(@PathVariable String prompt) { //Status 204

    }

}
