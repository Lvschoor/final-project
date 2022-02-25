package be.intecbrussel.finalproject.controllers.implementations;

import be.intecbrussel.finalproject.controllers.interfaces.SignUpController;
import be.intecbrussel.finalproject.data.Member;
import be.intecbrussel.finalproject.services.interfaces.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
@Controller
public class SignUpControllerImpl implements SignUpController {

    private MemberService memberService;

    public SignUpControllerImpl(MemberService memberService) {
        this.memberService = memberService;
    }

    @Override
    @GetMapping("signup")
    public String goToSignUp(Model model, HttpSession httpSession) {

        return "signup";
    }

    @Override
    @PostMapping("signup2")
    public String signUp(String email, String password, String repeatedPassword, HttpSession httpSession) {
        System.out.println(email+" / "+password+" / "+repeatedPassword);
        if (password.equals(repeatedPassword)){
            Member newMember = new Member(email, password);
            memberService.addMember(newMember);
            return "redirect:login";
        }
        else return "redirect:signup";

    }
}
