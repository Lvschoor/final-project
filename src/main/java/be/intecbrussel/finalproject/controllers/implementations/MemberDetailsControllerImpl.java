package be.intecbrussel.finalproject.controllers.implementations;

import be.intecbrussel.finalproject.controllers.interfaces.MemberDetailsController;
import be.intecbrussel.finalproject.services.interfaces.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MemberDetailsControllerImpl implements MemberDetailsController {

    private MemberService memberService;

    @Autowired
    public MemberDetailsControllerImpl(MemberService memberService) {
        this.memberService = memberService;
    }

    @Override
    @GetMapping("memberdetails")
    public String showCoachDetail(Model model) {

        return "memberdetails";
    }
}
