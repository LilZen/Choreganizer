package org.launchcode.choreganizer.controllers;

import org.launchcode.choreganizer.models.CreateCleaner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class LoginController {

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String getLoginCleaner(Model model) {
        model.addAttribute(new CreateCleaner());
        model.addAttribute("title", "Login");
            return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String verifyLoginCleaner(Model model, @ModelAttribute @Valid CreateCleaner cleaner,
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
            return "home";
        }

        return "login";
    }
    @RequestMapping(value="registration", method = RequestMethod.GET)
    public String registerCleaner (Model model) {
        model.addAttribute((new CreateCleaner()));
        model.addAttribute("title", "register");
        return "registration";
    }
    @RequestMapping(value = "registration", method = RequestMethod.POST)
        public String verifyRegisterCleaner(Model model, @ModelAttribute @Valid CreateCleaner cleaner, Errors errors, String verify) {

        model.addAttribute(cleaner);
        boolean passwordsMatch = true;
        if (cleaner.getPassword() == null || verify == null
                || !cleaner.getPassword().equals(verify)) {
            passwordsMatch = false;
            cleaner.setPassword("");
            model.addAttribute("verifyError", "Passwords must match");
        }

        if (!errors.hasErrors() && passwordsMatch) {
            return "home";
        }

        return "login";
    }
}
