package org.launchcode.employee.controllers;

import org.launchcode.employee.models.Skill;
import org.launchcode.employee.models.data.EmployeeDao;
import org.launchcode.employee.models.data.SkillDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by mkabd on 7/25/2017.
 */
@Controller
@RequestMapping("skill")
public class SkillController {

    @Autowired
    private SkillDao skillDao;

    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("skills", skillDao.findAll());
        model.addAttribute("title", "Skills");

        return "skill/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute(new Skill());
        model.addAttribute("title", "Add Skills");


        return "skill/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model,
                      @ModelAttribute @Valid Skill skill, Errors errors) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Skills");

            return "skill/add";
        }






        skillDao.save(skill);


        return "redirect:";
    }
    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveSkillForm(Model model) {
        model.addAttribute("skills", skillDao.findAll());
        model.addAttribute("title", "Remove Skill");
        return "skill/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveSkillForm(@RequestParam int[] skillIds) {

        for (int skillId : skillIds) {
            skillDao.delete(skillId);
        }


        return "redirect:";
    }




}
