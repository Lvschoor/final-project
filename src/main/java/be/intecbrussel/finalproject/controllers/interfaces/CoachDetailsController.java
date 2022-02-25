package be.intecbrussel.finalproject.controllers.interfaces;

import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

public interface CoachDetailsController {

    String showCoachDetail(Model model , HttpSession httpSession);



}

