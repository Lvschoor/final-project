package be.intecbrussel.finalproject.controllers.implementations;

import be.intecbrussel.finalproject.controllers.interfaces.MemberDashController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberDashControllerImpl implements MemberDashController {
    @Override
    @GetMapping("memberdash")
    public String goToMemberDash(Model model) {
        return "memberdash";
    }
}
