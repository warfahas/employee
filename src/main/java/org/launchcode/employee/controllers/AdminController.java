package org.launchcode.employee.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

/**
 * Created by mkabd on 1/24/2018.
 */
@RestController
public class AdminController {

    @RequestMapping("/admin")
    public Map<String,String> admin() {
        return Collections.singletonMap("password", "#s1pGo #gottacatchemall");
    }
}