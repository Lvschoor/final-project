package be.intecbrussel.finalproject.data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Member {
    @Id
    private String email;
    private String password;
}
