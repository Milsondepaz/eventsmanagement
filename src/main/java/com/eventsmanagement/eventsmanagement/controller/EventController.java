package com.eventsmanagement.eventsmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class EventController {

    @GetMapping
    public String Text( ) {

        return "Index";
    }





    /*
    @PostMapping
    public String register(@Valid Person person, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("message", "Registration not successful...");
            return "register";
        } else {
            model.addAttribute("message", "Registration sucessfully...");
            return "register";
        }
    }
   */

}
