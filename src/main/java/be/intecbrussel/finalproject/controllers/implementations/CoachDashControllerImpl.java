package be.intecbrussel.finalproject.controllers.implementations;

import be.intecbrussel.finalproject.controllers.interfaces.CoachDashController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CoachDashControllerImpl implements CoachDashController {
    @Override
    @GetMapping("coachdash")
    public String goToCoachDash(Model model) {
        return "coachdash";
    }
}
