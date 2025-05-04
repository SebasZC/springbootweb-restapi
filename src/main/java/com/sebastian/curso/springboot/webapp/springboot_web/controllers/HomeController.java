package com.sebastian.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @GetMapping({"","/","/home"})
    public String home() {
        return "redirect:/details";
    }
    
    @GetMapping({"/forward"})
    public String home2() {
        return "forward:/list";
    }

}
