package be.intecbrussel.finalproject.controllers.implementations;

import be.intecbrussel.finalproject.controllers.interfaces.LoginController;
import be.intecbrussel.finalproject.data.Owner;
import be.intecbrussel.finalproject.services.interfaces.CoachService;
import be.intecbrussel.finalproject.services.interfaces.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginControllerImpl implements LoginController {

    private OwnerService ownerService;
    private CoachService coachService;


    public LoginControllerImpl(OwnerService ownerService, CoachService coachService) {
        this.ownerService = ownerService;
        this.coachService = coachService;
    }


    @Override
    @GetMapping("login")
    public String goToLogin(Model model, HttpSession httpSession, @ModelAttribute("logout") String logout) {
                if(httpSession.getAttribute("user")==null || logout.equals("true")) {
            return "login";
        }
        else if ((httpSession.getAttribute("usertype").equals("owner"))) return "redirect:ownerdash";
        else return "redirect:coachdash";
    }

    @Override
    @PostMapping("login2")
    public String login(@ModelAttribute("email") String email, @ModelAttribute("password") String password, HttpSession httpSession) {
        if ((email.equals("owner@jgs.com"))&&(password.equals("12345"))){
            System.out.println("this is the owner logging in");
            httpSession.setAttribute("user", email);
            httpSession.setAttribute("usertype", "owner");
            System.out.println(httpSession.getAttribute("user"));
            return "redirect:ownerdash";
        }
        else if (coachService.getCoach(email)!=null){
            System.out.println(email);
            httpSession.setAttribute("user", email);
            httpSession.setAttribute("usertype", "coach");
            return "redirect:coachdash";
        }
        else return "redirect:login";
    }


}
