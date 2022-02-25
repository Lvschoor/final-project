package be.intecbrussel.finalproject.controllers.interfaces;

import be.intecbrussel.finalproject.data.Coach;
import be.intecbrussel.finalproject.data.PersonInfo;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

public interface ChangeCoachDetailsController {

    String changeDetailsCoach(Coach coachReceived, PersonInfo personInfoReceived, HttpSession httpSession);
    String goToPage(Model model, HttpSession httpSession);
}
