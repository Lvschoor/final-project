package be.intecbrussel.finalproject.controllers.implementations;

import be.intecbrussel.finalproject.controllers.interfaces.ListCoachesController;
import be.intecbrussel.finalproject.data.Coach;
import be.intecbrussel.finalproject.services.interfaces.CoachService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Controller
public class ListCoachesControllerImpl implements ListCoachesController {

    private CoachService coachService;

    public ListCoachesControllerImpl(CoachService coachService){
        this.coachService = coachService;
    }

    @Override
    @GetMapping("coaches")
    public String listCoaches(Model model) {
        List<Coach> coaches = coachService.getAllCoaches();
        model.addAttribute("coaches", coaches);
        return "coaches";
    }
}
