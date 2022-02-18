package be.intecbrussel.finalproject.data;

import javax.persistence.*;
import java.util.List;

@Entity
public class Owner {
    @Id
    private String email;
    private String password;
    @OneToOne
    private PersonInfo personInfo;
    @OneToMany
    private List<Coach> coaches;

    public PersonInfo getPersonInfo() {
        return personInfo;
    }


    public Owner(){

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    public void setCoaches(List<Coach> coaches) {
        this.coaches = coaches;
    }

    public void setPersonInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
    }
}
