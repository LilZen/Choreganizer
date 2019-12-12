package org.launchcode.choreganizer.controllers;

import org.launchcode.choreganizer.models.Chore;
import org.launchcode.choreganizer.models.Cleaner;
import org.launchcode.choreganizer.models.Login;
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
import java.util.List;

@Controller
@RequestMapping(value = "chore")
public class ChoreController{

    @Autowired
    ChoreDao choreDao;

    @Autowired
    CleanerDao cleanerDao;

    @RequestMapping(value="")
    public String home(Model model){

        model.addAttribute("chores", choreDao.findAll());
        model.addAttribute("title", "Choreganizer");
        return "chore/home";
    }

    @RequestMapping(value="add", method = RequestMethod.GET)
    public String displayAddChore(Model model){
        model.addAttribute("title", "Add Chore");
        model.addAttribute(new Chore());
        model.addAttribute("cleaners", cleanerDao.findAll());
        return "chore/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@ModelAttribute @Valid Chore newChore, Errors errors, @RequestParam int cleanerId, Model model) {

        if(errors.hasErrors()) {
            model.addAttribute("title", "Add Chore");
            model.addAttribute("cleaners", cleanerDao.findAll());
            return "chore/add";
        }

        Cleaner clean  = cleanerDao.findById(cleanerId).orElse(null);
        newChore.setCleaner(clean);
        choreDao.save(newChore);
        return "redirect:";
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String displayRemoveChore(Model model){

        model.addAttribute("chores", choreDao.findAll());
        model.addAttribute("title", "Delete Chore");
        return "chore/delete";
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String processRemoveChore(@RequestParam int[] ids) {

        for (int id : ids) {
            choreDao.deleteById(id);
        }

        return "redirect:";
    }

    @RequestMapping(value = "cleaner", method = RequestMethod.GET)
    public String category(Model model, @RequestParam int id) {

        Cleaner clean = cleanerDao.findById(id).orElse(null);
        List<Chore> chores = clean.getChores();
        model.addAttribute("chores", chores);
        model.addAttribute("title", "Chores for Cleaner: " + clean.getName());
        return "chore/home";
    }
}