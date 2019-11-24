package org.launchcode.choreganizer.controllers;

import org.launchcode.choreganizer.models.Chore;
import org.launchcode.choreganizer.models.Cleaner;
import org.launchcode.choreganizer.models.data.ChoreDao;
import org.launchcode.choreganizer.models.data.CleanerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class ChoreController {

    @Autowired
    ChoreDao choreDao;

    @Autowired
    CleanerDao cleanerDao;

    @RequestMapping(value="home")
    public String findChore(Model model){

        model.addAttribute("chores", choreDao.findAll());
        model.addAttribute("title", "Chores");

        return "home";
    }

    @RequestMapping(value="add", method = RequestMethod.GET)
    public String displayAddChore(Model model){

        model.addAttribute("title", "Add Chore");
        model.addAttribute(new Chore());
        model.addAttribute("chores", choreDao.findAll());
        return "add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String displayAddChore(@ModelAttribute @Valid Chore newChore, Errors errors, @RequestParam int cleanerId, Model model) {

        if(errors.hasErrors()) {
            model.addAttribute("title", "Add Chore");
            model.addAttribute("cleaners", cleanerDao.findAll());
            return "add";
        }

        Cleaner clean = cleanerDao.findById(cleanerId).orElse(null);
        newChore.setCleaner( clean );
        choreDao.save(newChore);
        return "";

    }
}
