package com.spring.SMS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }


    @GetMapping("/addFees")
    public String addFees() {
        return "addFees";
    }
}
