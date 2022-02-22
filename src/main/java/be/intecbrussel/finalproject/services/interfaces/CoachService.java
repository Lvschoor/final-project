package be.intecbrussel.finalproject.services.interfaces;

import be.intecbrussel.finalproject.data.Coach;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CoachService {

    List<Coach> getAllCoaches();
    void addCoach(Coach coach);
    public Coach getCoach (String email);
    void deleteCoach(Coach coach);

}
