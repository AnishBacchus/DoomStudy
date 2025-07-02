package study.app.DoomStudy.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import study.app.DoomStudy.Classes.UserAccount;
import study.app.DoomStudy.Repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public ResponseEntity<String> create(UserAccount user){
        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User account created!");
    }

}
