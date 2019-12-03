package org.launchcode.choreganizer.controllers;

import org.launchcode.choreganizer.models.Login;
import org.launchcode.choreganizer.models.data.LoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("login")
public class LoginController {

    @Autowired
    LoginDao loginDao;

    @RequestMapping(value = " ", method = RequestMethod.GET)
    public String getLoginCleaner(Model model) {
        model.addAttribute(new Login());
        model.addAttribute("title", "Login");
            return "login/login";
    }

    @RequestMapping(value = " ", method = RequestMethod.POST)
    public String verifyLoginCleaner(Model model, @ModelAttribute @Valid Login cleaner,
                               Errors errors, String verify) {

        model.addAttribute(cleaner);
        boolean passwordsMatch = true;
        if (cleaner.getPassword() == null || verify == null
                || !cleaner.getPassword().equals(verify)) {
            passwordsMatch = false;
            cleaner.setPassword("");
            model.addAttribute("verifyError", "Passwords must match");
        }

        if (!errors.hasErrors() && passwordsMatch) {
            return "chore/home";
        }

        return "login/login";
    }
    @RequestMapping(value="registration", method = RequestMethod.GET)
    public String registerCleaner (Model model) {
        model.addAttribute((new Login()));
        model.addAttribute("title", "register");
        return "login/registration";
    }
    @RequestMapping(value = "registration", method = RequestMethod.POST)
        public String verifyRegisterCleaner(Model model, @ModelAttribute @Valid Login cleaner, Errors errors, String verify) {

        model.addAttribute(cleaner);
        boolean passwordsMatch = true;
        if (cleaner.getPassword() == null || verify == null
                || !cleaner.getPassword().equals(verify)) {
            passwordsMatch = false;
            cleaner.setPassword("");
            model.addAttribute("verifyError", "Passwords must match");
        }

        if (!errors.hasErrors() && passwordsMatch) {
            return "chore/home";
        }

        return "login/login";
    }
}
