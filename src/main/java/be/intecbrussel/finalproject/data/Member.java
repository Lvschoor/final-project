package be.intecbrussel.finalproject.data;

import javax.persistence.*;
import java.util.List;

@Entity
public class Member {
    @Id
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @OneToOne
    private PersonInfo personInfo;
    @ManyToMany(cascade=CascadeType.PERSIST)
    private List<Session> sessions;

    public Member() {
    }

    public Member(String email, String password) {
        this.email = email;
        this.password = password;
;
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

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public PersonInfo getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
    }


}
