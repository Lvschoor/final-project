package be.intecbrussel.finalproject.controllers.implementations;

import be.intecbrussel.finalproject.controllers.interfaces.LoginController;
import be.intecbrussel.finalproject.data.Coach;
import be.intecbrussel.finalproject.data.Member;
import be.intecbrussel.finalproject.services.interfaces.CoachService;
import be.intecbrussel.finalproject.services.interfaces.MemberService;
import be.intecbrussel.finalproject.services.interfaces.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginControllerImpl implements LoginController {

    private final OwnerService ownerService;
    private final CoachService coachService;
    private final MemberService memberService;


    public LoginControllerImpl(OwnerService ownerService, CoachService coachService, MemberService memberService) {
        this.ownerService = ownerService;
        this.coachService = coachService;
        this.memberService = memberService;
    }


    @Override
    @GetMapping("login")
    public String goToLogin(Model model, HttpSession httpSession, @ModelAttribute("logout") String logout) {
        if (httpSession.getAttribute("user") == null || logout.equals("true")) {
            httpSession.setAttribute("user", null);
            httpSession.setAttribute("usertype", null);
            return "login";
        }
        else if ((httpSession.getAttribute("usertype").equals("owner"))) return "redirect:ownerdash";
        else if ((httpSession.getAttribute("usertype").equals("coach"))) return "redirect:coachdash";
        else return "redirect:memberdash";

    }

    @Override
    @PostMapping("login2")
    public String login(@ModelAttribute("email") String email, @ModelAttribute("password") String password, HttpSession httpSession) {
        System.out.println(email+"/"+password+"/"+ httpSession.getAttribute("user")+"/"+ httpSession.getAttribute("usertype"));
        List<Coach> allCoaches = coachService.getAllCoaches();
        List<String> emailOfAllCoaches=new ArrayList<>();
        for (Coach coach : allCoaches){
            emailOfAllCoaches.add(coach.getEmail());
        }

        if ((email.equals("owner@jgs.com")) && (password.equals("12345"))) {
            System.out.println("This is the owner logging in");
            httpSession.setAttribute("user", email);
            httpSession.setAttribute("usertype", "owner");
            System.out.println(httpSession.getAttribute("user"));
            return "redirect:ownerdash";
            //
            //coachService.getCoach(email) != null
        } else if (emailOfAllCoaches.contains(email)) {
            System.out.println("A coach logging in with email: " + email);
            Coach loggedInCoach = coachService.getCoach(email);
            if (loggedInCoach.getPassword().equals(password)) {
                httpSession.setAttribute("user", email);
                httpSession.setAttribute("usertype", "coach");
                System.out.println(httpSession.getAttribute("user"));
                return "redirect:coachdash";
            } else return "redirect:login";

        } else if (memberService.getMember(email) != null) {
            System.out.println("A member logging in with email: " + email);
            Member member = memberService.getMember(email);
            if (member.getPassword().equals(password)) {
                httpSession.setAttribute("user", email);
                httpSession.setAttribute("usertype", "member");
                System.out.println(httpSession.getAttribute("user"));
                return "redirect:memberdash";
            } else return "redirect:login";
        } else return "redirect:login";
    }
}
