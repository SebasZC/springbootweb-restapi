package com.sebastian.curso.springboot.webapp.springboot_web.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sebastian.curso.springboot.webapp.springboot_web.dto.UserDto;
import com.sebastian.curso.springboot.webapp.springboot_web.models.User;

@RestController //Para aplicaciones Rest (tipo json) y usar para que se pueda enviar y obtener información
@RequestMapping("/api") //Ruta de primer nivel
public class UserRestController {

    @GetMapping("/details") //ruta para acceder
    public UserDto details(){

        UserDto userDto = new UserDto();
        User user = new User("Sebastian", "Zapata");
        userDto.setUser(user);
        userDto.setTitle("Hola Mundo Spring Boot - DTO");
        
        return userDto;
    }

    @GetMapping("/list")
    public List<User> list(){
        User user = new User("Sebastian", "Zapata");
        User user2 = new User("William", "Ossa");
        User user3 = new User("Jhoan", "Perez", "joan@gmmail.com");

        //Esto puede ser un método, agregando uno a uno
        //List<User> users = new ArrayList<>();
        //users.add(user);
        //users.add(user2);
        //users.add(user3);

        List<User> users = Arrays.asList(user,user2,user3);
        
        return users;
    }

    @GetMapping("/details-map") //ruta para acceder
    public Map<String, Object> detailsMap(Model model){
        User user = new User("Sebastian", "Zapata");
        Map<String, Object> body = new HashMap<>();
        body.put("title", "Hola Mundo Spring Boot - MAP");
        body.put("user", user);
        
        return body;
    }
}
