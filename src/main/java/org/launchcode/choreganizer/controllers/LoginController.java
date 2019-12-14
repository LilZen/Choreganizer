package org.launchcode.choreganizer.controllers;

import org.launchcode.choreganizer.models.Login;
import org.launchcode.choreganizer.models.data.ChoreDao;
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
public class LoginController{

    @Autowired
    LoginDao loginDao;

    @Autowired
    ChoreDao choreDao;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getLoginUser(Model model) {
        model.addAttribute(new Login());
        model.addAttribute("title", "Login");
        return "login/login";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String verifyLoginUser(@ModelAttribute @Valid Login newUser, Errors errors, Model model){

        if(errors.hasErrors()) {
            model.addAttribute("title", "Choreganizer Sign-In");
            return "login/login";
        }

        Login user = loginDao.findByUser(newUser.getUser());
        if(user != null && user.getUser().equalsIgnoreCase(newUser.getUser())) {
            model.addAttribute("chores", choreDao.findAll());
            model.addAttribute("title", "Chores");
            return "/chore/home";
        }

        model.addAttribute("login", "Invalid Credentials");
        newUser.setPassword("");
        return "login/login";
    }
    @RequestMapping(value="registration", method = RequestMethod.GET)
    public String registerUser (Model model) {
        model.addAttribute((new Login()));
        model.addAttribute("title", "Register");
        return "login/registration";
    }
    @RequestMapping(value = "registration", method = RequestMethod.POST)
        public String verifyRegisterUser(Model model, @ModelAttribute @Valid Login user, Errors errors) {

        model.addAttribute(user);

        if (!errors.hasErrors()) {
            loginDao.save(user);

            model.addAttribute("chores", choreDao.findAll());
            model.addAttribute("title", "Chores");
            return "/chore/home";
        }

        model.addAttribute("registration", "Passwords do not match.");
        user.setPassword("");

        return "redirect:/login/registration ";
    }
}
