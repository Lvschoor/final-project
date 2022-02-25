package be.intecbrussel.finalproject.controllers.implementations;

import be.intecbrussel.finalproject.controllers.interfaces.ChangeCoachDetailsController;
import be.intecbrussel.finalproject.data.Coach;
import be.intecbrussel.finalproject.data.PersonInfo;
import be.intecbrussel.finalproject.services.interfaces.CoachService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
@Controller
public class ChangeCoachDetailsControllerImpl implements ChangeCoachDetailsController {

    private CoachService coachService;

    public ChangeCoachDetailsControllerImpl(CoachService coachService) {
        this.coachService = coachService;
    }

    @Override
    @GetMapping("updatecoachdetails")
    public String goToPage(Model model, HttpSession httpSession) {
        String mail = httpSession.getAttribute("user").toString();
        Coach coach = coachService.getCoach(mail);
        PersonInfo personInfo = coach.getPersonInfo();
        model.addAttribute("coach", coach);
        model.addAttribute("personInfo", personInfo);
        return "updatecoachdetails";
    }


    @Override
    @PostMapping("updatecoach")
    public String changeDetailsCoach(Coach coachReceived, PersonInfo personInfoReceived, HttpSession httpSession) {
        coachReceived.setPersonInfo(personInfoReceived);
        coachService.updateCoach(coachReceived);
        return "redirect:coachdetails";
    }

}
