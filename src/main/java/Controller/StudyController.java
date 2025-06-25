package Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudyController {

    //-----------------------------------------------------------------------------------------------------------
    // Method to add prompt.

    @PostMapping("/add")
    public void addPrompt() { //Status 201

    }
    //-----------------------------------------------------------------------------------------------------------
    //Method to get all the prompts created.

    @GetMapping("/get")
    public void getPrompt() { //Status 200

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

