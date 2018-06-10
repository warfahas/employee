package org.launchcode.employee.controllers;

import org.launchcode.employee.models.User;
import org.launchcode.employee.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by mkabd on 7/8/2017.
 */
//@CrossOrigin
//@RestController
@Controller
@RequestMapping(value = "/user")
public class UserController {


    @Autowired
    private UserDao userDao;




    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("users", userDao.findAll());
        model.addAttribute("title", "Users");

        return "user/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {

        model.addAttribute(new User());
        model.addAttribute("title", "Register");
        return "user/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid User user, Errors errors) {

        if (errors.hasErrors()) {

            model.addAttribute("title", "Add User");

            return "user/add";
        }

        userDao.save(user);

        return "redirect:";


    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(Model model, User user) {

        User currentUser = userDao.findByEmail(user.getEmail());

        model.addAttribute("user", user);


        model.addAttribute("title", "Login");






        return "user/login";

    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String processLogin(Model model, @ModelAttribute @Valid User user, Errors errors) {

        if (user.getEmail().isEmpty() || user.getPassword().isEmpty()) {
            model.addAttribute("title", "Login");

            return "user/login";
        }
        else {
            User currentUser = userDao.findByEmail(user.getEmail());

            model.addAttribute("username", user.getEmail());
            model.addAttribute("password", user.getPassword());

            return "redirect:/employee/";


        }














        //return "redirect:/employee/";
    }








}