package be.intecbrussel.finalproject.controllers.implementations;

import be.intecbrussel.finalproject.controllers.interfaces.MemberDetailsController;
import be.intecbrussel.finalproject.data.Coach;
import be.intecbrussel.finalproject.data.Member;
import be.intecbrussel.finalproject.services.interfaces.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;


@Controller
public class MemberDetailsControllerImpl implements MemberDetailsController {

    private MemberService memberService;

    @Autowired
    public MemberDetailsControllerImpl(MemberService memberService) {
        this.memberService = memberService;
    }

    @Override
    @GetMapping("memberdetails")
    public String showCoachDetail(Model model, HttpSession httpSession) {
        String mail = httpSession.getAttribute("user").toString();
        System.out.println(mail);
        Member member = memberService.getMember(mail);
        System.out.println(member.getPersonInfo().getFirstName());
        model.addAttribute("member", member);
        return "memberdetails";
    }
}
