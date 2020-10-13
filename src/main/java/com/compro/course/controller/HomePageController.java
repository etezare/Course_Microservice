package com.compro.course.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @GetMapping(value = { "/", "/courses" })
    public String displayHomePage() {
        return "home/index";

    }

}