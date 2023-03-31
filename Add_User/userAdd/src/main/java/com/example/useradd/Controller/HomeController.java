package com.example.useradd.Controller;

import com.example.useradd.Entity.Users;
import com.example.useradd.Repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    UserRepository userRepository;
    @GetMapping("/home")
    public String homePage(Model model){
        List<Users> listUsers = userRepository.findAll();
        model.addAttribute("Users",listUsers);
        return "index";
    }
}
