package org.launchcode.choreganizer.controllers;

import org.launchcode.choreganizer.models.Chore;
import org.launchcode.choreganizer.models.data.ChoreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.Id;

@Controller
public class ChoreController {

    @Autowired
    ChoreDao choreDao;

    @RequestMapping(value="home")
    public String findChore(Model model){

        model.addAttribute("chores", choreDao.findAll());
        model.addAttribute("title", "Chores");

        return "home";
    }

    @RequestMapping(value="add")
    public String addChore(Model model){

        model.addAttribute("title", "Add Chore");
        model.addAttribute(new Chore());
        model.addAttribute("chores", choreDao.findAll());
        return "add";
    }
}
