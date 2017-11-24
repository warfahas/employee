package org.launchcode.employee.controllers;

import org.launchcode.employee.models.Employee;
import org.launchcode.employee.models.Skill;
import org.launchcode.employee.models.data.EmployeeDao;
import org.launchcode.employee.models.data.SkillDao;
import org.launchcode.employee.models.forms.AddSkillForm;
import org.launchcode.employee.models.forms.DeleteSkillForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by mkabd on 7/8/2017.
 */
@Controller
@RequestMapping(value = "employee")
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private SkillDao skillDao;

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("employees", employeeDao.findAll());
        model.addAttribute("title", "Employees");



        return "employee/index";

    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String addEmployees(Model model) {

        model.addAttribute("title", "Add Employees");
        model.addAttribute(new Employee());



        return "employee/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addEmployees(Model model,
                               @ModelAttribute @Valid Employee employee, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Employees");
            return "employee/add";
        }




        employeeDao.save(employee);


        return "redirect:details/" + employee.getId();
    }

    @RequestMapping(value = "details/{id}", method = RequestMethod.GET)
    public String viewEmployee(Model model, @PathVariable int id) {

        Employee employee = employeeDao.findOne(id);

        model.addAttribute("employee", employee);
        model.addAttribute("title", employee.getFirstName() + ' ' + employee.getLastName());

        return "employee/details";

    }

    @RequestMapping(value = "add-item/{id}", method = RequestMethod.GET)
    public String addItem(Model model, @PathVariable int id ) {

        Employee employee = employeeDao.findOne(id);

        AddSkillForm form = new AddSkillForm(employee, skillDao.findAll());

        model.addAttribute("form", form);
        model.addAttribute("title", "Add skill to employee: " + employee.getFirstName() + ' ' + employee.getLastName());


        return "employee/add-item";
    }

    @RequestMapping(value = "add-item/{id}", method = RequestMethod.POST)
    public String addItem(Model model, @ModelAttribute @Valid AddSkillForm form,
                          Errors errors, @PathVariable int id) {
        if (errors.hasErrors()) {
            Employee employee = employeeDao.findOne(id);
            model.addAttribute("title", "Add skill to employee: " + employee.getFirstName() + employee.getLastName());
            model.addAttribute("form", form);


            return "employee/add-item";
        }

        Employee employee = employeeDao.findOne(form.getEmployeeId());
        Skill skill = skillDao.findOne(form.getSkillId());

        employee.addItem(skill);
        employeeDao.save(employee);

        return "redirect:/employee/details/" + employee.getId();

    }
    @RequestMapping(value = "delete-item/{id}", method = RequestMethod.GET)
    public String deleteItem(Model model, @PathVariable int id ) {

        Employee employee = employeeDao.findOne(id);


        DeleteSkillForm form = new DeleteSkillForm(employee, skillDao.findAll());

        model.addAttribute("form", form);
        model.addAttribute("title", "Delete employee and skill from employee list: " + employee.getFirstName() + ' ' + employee.getLastName());


        return "employee/delete-item";
    }

    @RequestMapping(value = "delete-item/{id}", method = RequestMethod.POST)
    public String deleteItem(Model model, @ModelAttribute @Valid DeleteSkillForm form,
                          Errors errors, @PathVariable int id, @RequestParam int[] skillIds) {
        if (errors.hasErrors()) {
            Employee employee = employeeDao.findOne(id);

            model.addAttribute("title", "Delete employee and skill from employee list: " + employee.getFirstName() + employee.getLastName());
            model.addAttribute("form", form);


            return "employee/delete-item";
        }


        Employee employee = employeeDao.findOne(form.getEmployeeId());
        Skill skill = skillDao.findOne(form.getSkillId());
        employee.deleteItem(skill);
        employeeDao.delete(employee);



        
        return "redirect:/employee/";


    }
    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updateItem(Model model,  @PathVariable int id) {

        Employee employee = employeeDao.findOne(id);



        model.addAttribute("title", "Update Employee");
        model.addAttribute(new Employee());

        return "employee/update";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.POST)
    public String updateItem(Model model,
                                  @ModelAttribute @Valid Employee employee, Errors errors, @PathVariable int id) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Update Employees");
            return "employee/update";
        }


        employeeDao.save(employee);


        return "redirect:/employee/details/" + employee.getId();


    }



}
