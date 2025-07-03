package study.app.DoomStudy.Classes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
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


    private String username;
    private String password;

    @OneToMany(mappedBy = "userAccount", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Prompt> prompts = new ArrayList<>();
}
