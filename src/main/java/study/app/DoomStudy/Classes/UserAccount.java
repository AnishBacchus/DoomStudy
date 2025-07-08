package study.app.DoomStudy.Classes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import java.util.*;

@Entity
@Getter
@Setter
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @JsonIgnore
    private long id;


    @Size(min = 4, max = 20, message = "Username length must be between 4 to 20 characters.")
    private String username;

    @Size(min = 8, max = 30, message = "Password length must be between 8 to 20 characters.")
    private String password;

    @Email(message = "Must be a valid email address.")
    private String email;

    @OneToMany(mappedBy = "userAccount", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Prompt> prompts = new ArrayList<>();
}
