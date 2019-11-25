package org.launchcode.choreganizer.controllers;

import org.launchcode.choreganizer.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class UserController {

@RequestMapping(value = "registration", method = RequestMethod.GET)
public String add(Model model) {
    model.addAttribute(new User());
    model.addAttribute("title", "Register");
        return "registration";
    }

    @RequestMapping(value = "registation", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid User user,
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

        return "registation";
    }


}
