package org.launchcode.employee.controllers;

import org.launchcode.employee.models.User;
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
@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {

        model.addAttribute(new User());
        model.addAttribute("title", "Register");
        return "user/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid User user, Errors errors, String verify) {

        model.addAttribute("user", user);

        boolean passwordsMatch = true;
        if(errors.hasErrors()){
            return "user/add";
            //passwordsMatch = false; to show error message for verify in form
        }
            if (user.getPassword() == null || verify == null
                    || !user.getPassword().equals(verify)){
            passwordsMatch = false;
            model.addAttribute("verify", "Passwords must match");
        }

        if (passwordsMatch) {
            return "user/index";
        }

        return "user/add";

    }


}