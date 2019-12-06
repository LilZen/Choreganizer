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

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getLoginCleaner(Model model) {
        model.addAttribute(new Login());
        model.addAttribute("title", "Login");
            return "login/login";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String verifyLoginCleaner(@Valid Login cleaner, Errors errors, String password, Model model) {

        model.addAttribute(cleaner);
        boolean passwordMatchUser = true;
        if(!cleaner.getPassword().equals(password)) {
            passwordMatchUser = false;
            model.addAttribute(password, "Invalid cleaner or password");

        }

        if(!errors.hasErrors() && passwordMatchUser) {
            return "redirect: chore/home";
        }
        return "login/login";
    }
    @RequestMapping(value="registration", method = RequestMethod.GET)
    public String registerCleaner (Model model) {
        model.addAttribute((new Login()));
        model.addAttribute("title", "Register");
        return "login/registration";
    }
    @RequestMapping(value = "registration", method = RequestMethod.POST)
        public String verifyRegisterCleaner(Model model, @ModelAttribute @Valid Login cleaner, Errors errors, String verifyPassword) {

        model.addAttribute(cleaner);
        boolean passwordsMatch = true;
        if (cleaner.getPassword() == null || verifyPassword == null
                || !cleaner.getPassword().equals(verifyPassword)) {
            passwordsMatch = false;
            cleaner.setPassword(" ");
            model.addAttribute(verifyPassword, "Passwords must match");
        }

        if (!errors.hasErrors() && passwordsMatch) {

            loginDao.save(cleaner);

            return "redirect: chore/home";
        }

        return "/login/registration ";
    }
}
