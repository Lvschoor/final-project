package be.intecbrussel.finalproject.controllers.interfaces;

import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

public interface SignUpController {

    String goToSignUp(Model model, HttpSession httpSession);
    String signUp(String email, String password, String repeatedPassword, HttpSession httpSession);
}
