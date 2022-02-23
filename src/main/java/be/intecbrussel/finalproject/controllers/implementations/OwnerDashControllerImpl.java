package be.intecbrussel.finalproject.controllers.implementations;

import be.intecbrussel.finalproject.controllers.interfaces.OwnerDashController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OwnerDashControllerImpl implements OwnerDashController {

    @Override
    @GetMapping("ownerdash")
    public String goToOwnerDash(Model model) {
        return "ownerdash";
    }
}
