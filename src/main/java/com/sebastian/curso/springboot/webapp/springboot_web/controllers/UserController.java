package com.sebastian.curso.springboot.webapp.springboot_web.controllers;


import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.sebastian.curso.springboot.webapp.springboot_web.models.User;

@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model){
        User user = new User("Sebastian", "Zapata");
        model.addAttribute("title", "Hola Mundo Spring Boot");
        model.addAttribute("user", user);
        
        return "details";
    }

    @GetMapping("/list")
    public String list(ModelMap model){
        model.addAttribute("title", "Listado de usuarios :)");
        return "list";
    }

    @ModelAttribute("users")
    public List<User> userModel(){
        List<User> users = Arrays.asList(
            new User("Pepa", "Gonzales"),
            new User("lalo", "Perez","laloperezgmail.com"),
            new User("Juancho","Roe","juachoroe123@hotmail.com"),
            new User("Andrés", "Doe"));
            
        return users;
    }
}
