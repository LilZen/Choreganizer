package org.launchcode.choreganizer.controllers;

import org.launchcode.choreganizer.models.Cleaner;
import org.launchcode.choreganizer.models.data.CleanerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("cleaner")
public class CleanerController{

    @Autowired
    private CleanerDao cleanerDao;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String home(Model model, @RequestParam(defaultValue = "0") int id) {
        model.addAttribute("title", "Cleaners");
        model.addAttribute("cleaners", cleanerDao.findAll());
        return "cleaner/home";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute(new Cleaner());
        model.addAttribute("title", "Add Cleaner");
        return "cleaner/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid Cleaner cleaner, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Cleaner");
            return "cleaner/add";
        }

        cleanerDao.save(cleaner);
        return "redirect:";
    }
}
