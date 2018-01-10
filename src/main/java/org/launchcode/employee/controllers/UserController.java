package org.launchcode.employee.controllers;

import org.launchcode.employee.models.User;
import org.launchcode.employee.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;

/**
 * Created by mkabd on 7/8/2017.
 */
@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping(value = "/user/add", method = RequestMethod.GET)
    public String showRegistrationForm(WebRequest request, Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "add";
    }



}