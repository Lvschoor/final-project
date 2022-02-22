package be.intecbrussel.finalproject.services.implementations;

import be.intecbrussel.finalproject.data.Coach;
import be.intecbrussel.finalproject.repositories.CoachRepository;
import be.intecbrussel.finalproject.services.interfaces.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CoachServiceImpl implements CoachService {

    private CoachRepository coachRepository;

    @Autowired
    public CoachServiceImpl(CoachRepository coachRepository) {
        this.coachRepository = coachRepository;
    }

    @Override
    public List<Coach> getAllCoaches() {
        return coachRepository.findAll();
    }

    @Override
    public void addCoach(Coach coach) {
        coachRepository.save(coach);
    }

    @Override
    public Coach getCoach (String email) {
        return coachRepository.getById(email);
    }

    @Override
    public void deleteCoach(Coach coach) {coachRepository.delete(coach);}

}
