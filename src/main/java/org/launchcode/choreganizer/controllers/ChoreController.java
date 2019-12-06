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

    @RequestMapping(value="")
    public String findChore(Model model){

        model.addAttribute("chores", choreDao.findAll());
        model.addAttribute("title", "Chores");

        return "chore/home";
    }

    @RequestMapping(value="add", method = RequestMethod.GET)
    public String displayAddChore(Model model){

        model.addAttribute("title", "Add Chore");
        model.addAttribute(new Chore());
        model.addAttribute("chores", choreDao.findAll());
        return "chore/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String displayAddChore(@ModelAttribute @Valid Chore newChore, Errors errors, @RequestParam int Id, Model model) {

        if(errors.hasErrors()) {
            model.addAttribute("title", "Add Chore");

            return "chore/add";
        }

        choreDao.save(newChore);
        return "chore/add";

    }

    @RequestMapping(value = " ", method = RequestMethod.POST)
    public String processRemoveChore(@RequestParam int[] ids) {

        for (int id : ids) {
            choreDao.deleteById(id);
        }

        return "redirect:";
    }
}
