package be.intecbrussel.finalproject.controllers.interfaces;

import be.intecbrussel.finalproject.data.Owner;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

public interface LoginController {

    String goToLogin(Model model, HttpSession httpSession, String logout);
    String login(String email, String password, HttpSession httpSession);
}
