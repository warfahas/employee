package org.launchcode.employee.controllers;

import org.launchcode.employee.models.CurrentUser;
import org.launchcode.employee.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mkabd on 1/23/2018.
 */
@CrossOrigin
@RestController
public class SecurityController {

    @RequestMapping(value = "/principal")
    public ResponseEntity<User> currentPrincipal(@CurrentUser User currentUser) {
        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
    }
}
