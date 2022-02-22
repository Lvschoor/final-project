package be.intecbrussel.finalproject.controllers.implementations;

import be.intecbrussel.finalproject.controllers.interfaces.AddCoachController;
import be.intecbrussel.finalproject.data.Coach;
import be.intecbrussel.finalproject.data.PersonInfo;
import be.intecbrussel.finalproject.services.interfaces.CoachService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class AddCoachControllerImpl implements AddCoachController {

    private CoachService coachService;
    public AddCoachControllerImpl(CoachService coachService){
        this.coachService = coachService;
    }

    @Override
    @GetMapping("addcoach")
    public String goToPage(Model model) {
        model.addAttribute("coach", new Coach());
        model.addAttribute("personInfo", new PersonInfo());
        return "addcoach";
    }

    @Override
    @PostMapping("addcoach2")
    public String addCoach(@ModelAttribute("coach") Coach coachReceived, @ModelAttribute("personInfo") PersonInfo personInfoReceived,HttpSession httpSession) {

/*        System.out.println(personInfoReceived.getFirstName());
        System.out.println(personInfoReceived.getLastName());
        System.out.println(coachReceived.getEmail());
        System.out.println(coachReceived.getPassword());*/
        coachReceived.setPersonInfo(personInfoReceived);
        //System.out.println(coachReceived.getPersonInfo().getFirstName());
        coachService.addCoach(coachReceived);
        return "redirect:coaches";
    }


}
