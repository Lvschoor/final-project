package be.intecbrussel.finalproject.controllers.implementations;

import be.intecbrussel.finalproject.controllers.interfaces.DeleteCoachController;
import be.intecbrussel.finalproject.data.Coach;
import be.intecbrussel.finalproject.services.interfaces.CoachService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DeleteCoachControllerImpl implements DeleteCoachController {

    private CoachService coachService;
    public DeleteCoachControllerImpl(CoachService coachService){
        this.coachService = coachService;
    }

    @Override
    @PostMapping("coachdelete")
    public String deleteCoach(@ModelAttribute(value = "emailcoach") Coach coach) {
        Coach coachToBeDeleted = coachService.getCoach(coach.getEmail());
        coachService.deleteCoach(coachToBeDeleted);
        return "redirect:coaches";
    }
}
