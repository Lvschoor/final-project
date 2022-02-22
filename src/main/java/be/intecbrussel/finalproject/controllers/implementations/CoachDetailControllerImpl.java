package be.intecbrussel.finalproject.controllers.implementations;

import be.intecbrussel.finalproject.controllers.interfaces.CoachDetailsController;
import be.intecbrussel.finalproject.data.Coach;
import be.intecbrussel.finalproject.services.interfaces.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class CoachDetailControllerImpl implements CoachDetailsController {

    private CoachService coachService;

    @Autowired
    public CoachDetailControllerImpl(CoachService coachService) {
        this.coachService = coachService;
    }

    @Override
    @GetMapping("coachdetails")
    public String showCoachDetail(Model model) {
        Coach coach = coachService.getCoach("coach@email.be");
        //System.out.println(coach.getEmail());
        model.addAttribute("coach", coach);
        //System.out.println(coach.getPassword());
        
        //model.addAttribute("password", coach.getPassword());
        return "coachdetails";
    }
}
