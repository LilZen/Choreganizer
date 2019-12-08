package org.launchcode.choreganizer.controllers;

import org.launchcode.choreganizer.models.Chore;
import org.launchcode.choreganizer.models.data.ChoreDao;
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
@RequestMapping(value = "chore")
public class ChoreController {

    @Autowired
    ChoreDao choreDao;

    @RequestMapping(value="", method = RequestMethod.GET)
    public String home(Model model, @RequestParam(defaultValue = "0") int id){

        model.addAttribute("title", "Chores");
        model.addAttribute("chores", choreDao.findAll());
        return "chore/home";
    }

    @RequestMapping(value="add", method = RequestMethod.GET)
    public String addChore(Model model){
        model.addAttribute(new Chore());
        model.addAttribute("title", "Add Chore");
        return "chore/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addChore(Model model, @ModelAttribute @Valid Chore chore, Errors errors) {

        if(errors.hasErrors()) {
            model.addAttribute("title", "Add Chore");
            return "chore/add";
        }

        choreDao.save(chore);
        return "chore/add";
    }
}
