package study.app.DoomStudy.Service;

import study.app.DoomStudy.Repository.PromptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import study.app.DoomStudy.Prompt;

import java.util.List;

@Service
public class PromptService {

    @Autowired
    PromptRepository promptRepository;

    public ResponseEntity<String> add(Prompt prompt){
        promptRepository.save(prompt);
        return ResponseEntity.status(HttpStatus.CREATED).body("Prompt added successfully.");
    }

    public ResponseEntity<List<Prompt>> get(){
        return ResponseEntity.status(HttpStatus.OK).body(promptRepository.findAll());
    }
}
