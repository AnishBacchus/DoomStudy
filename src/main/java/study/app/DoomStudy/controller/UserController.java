package study.app.DoomStudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import study.app.DoomStudy.Classes.UserAccount;
import study.app.DoomStudy.Service.UserService;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    //-----------------------------------------------------------------------------------------------------------
    // Method to add user.

    @PostMapping("/create")
    public ResponseEntity<String> addUser(@RequestBody UserAccount userAccount) { //Status 201
        return userService.create(userAccount);
    }


}
