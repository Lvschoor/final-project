package be.intecbrussel.finalproject.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Coach {
    @Id
    private String email;
    @Column(nullable = false)
    private String password;
    @OneToMany(mappedBy = "coach")
    private List<Session> sessions;
    private String imageLocation;


    public Coach() {
    }

    public Coach(String email, String password, List<Session> sessions, String imageLocation) {
        this.email = email;
        this.password = password;
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

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }
}
