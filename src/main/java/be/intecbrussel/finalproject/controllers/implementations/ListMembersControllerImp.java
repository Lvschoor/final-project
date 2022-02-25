package be.intecbrussel.finalproject.controllers.implementations;

import be.intecbrussel.finalproject.controllers.interfaces.ListMembersController;
import be.intecbrussel.finalproject.data.Member;
import be.intecbrussel.finalproject.services.interfaces.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ListMembersControllerImp implements ListMembersController {

    private MemberService memberService;

    public ListMembersControllerImp(MemberService memberService) {
        this.memberService = memberService;
    }

    @Override
    @GetMapping("members")
    public String listMembers(Model model) {
        List<Member> members = memberService.getAllMembers();
        model.addAttribute("members", members);
        members.forEach(member -> System.out.println(member.getEmail()));
        return "members";
    }
}
