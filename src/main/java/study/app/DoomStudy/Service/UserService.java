package study.app.DoomStudy.Service;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import study.app.DoomStudy.Classes.UserAccount;
import study.app.DoomStudy.Repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    //-----------------------------------------------------------------------------------------------------------
    //Method to create a user account.

    public ResponseEntity<String> create(UserAccount user){
        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User account created!");
    }

    //-----------------------------------------------------------------------------------------------------------
    //Method to find user account by its id.

    public Optional<UserAccount> findById(Long id){
        return userRepository.findById(id);
    }

}
