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

    @RequestMapping(value = "registration", method = RequestMethod.GET)
    public String registerCleaner(Model model) {
        model.addAttribute(new CreateCleaner());
        model.addAttribute("title", "register");
            return "registration";
    }

    @RequestMapping(value = "registration", method = RequestMethod.POST)
    public String registerCleaner(Model model, @ModelAttribute @Valid CreateCleaner user,
                                  Errors errors, String verify) {

        model.addAttribute(user);
        boolean passwordsMatch = true;
        if (user.getPassword() == null || verify == null
                || !user.getPassword().equals(verify)) {
            passwordsMatch = false;
            user.setPassword("");
            model.addAttribute("verifyError", "Passwords must match");
        }

        if (!errors.hasErrors() && passwordsMatch) {
            return "home";
        }

        return "Registration";
    }
}
