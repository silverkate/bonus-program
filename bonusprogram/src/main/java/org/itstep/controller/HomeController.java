package org.itstep.controller;

import org.itstep.domain.User;
import org.itstep.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @Autowired
    private UserRepository userRepository;


    @GetMapping
    public String home() {
        return "index";
    }
    @GetMapping(path = "/info")
    public String info() {
        return "info";
    }

}