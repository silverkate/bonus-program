package org.itstep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BusinessController {
    @GetMapping(path = "/business/enter")
    public String ent() {
        return "business/enter";
    }
}
