package be.intecbrussel.finalproject.data;



import javax.persistence.*;
import java.util.Set;

@Entity
public class Coach {
    @Id
    private String email;
    @Column(nullable = false)
    private String password;
    @OneToOne (cascade = {CascadeType.ALL})
    private PersonInfo personInfo;
    @OneToMany(mappedBy = "coach")
    private Set<Session> sessions;
    private String imageLocation;


    public Coach() {
    }

    public Coach(String email, String password, PersonInfo personInfo, Set<Session> sessions, String imageLocation) {
        this.email = email;
        this.password = password;
        this.personInfo = personInfo;
        this.sessions = sessions;
        this.imageLocation = imageLocation;
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
    public Set<Session> getSessions() {
        return sessions;
    }

    public void setSessions(Set<Session> sessions) {
        this.sessions = sessions;
    }

    public PersonInfo getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }

}
