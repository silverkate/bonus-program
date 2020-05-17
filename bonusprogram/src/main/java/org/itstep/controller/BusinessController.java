package org.itstep.controller;

import org.itstep.service.TransactionService;
import org.itstep.service.UserService;
import org.itstep.service.dto.TransactionDto;
import org.itstep.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BusinessController {
    final UserService userService;
    final TransactionService transactionService;

    @Autowired
    public BusinessController(UserService userService, TransactionService transactionService) {
        this.userService = userService;
        this.transactionService = transactionService;
    }

    @GetMapping(path = "/business/enter")
    public String ent() {
        return "business/enter";
    }

    @GetMapping(path = "/business/account")
    public String account() {
        return "business/account";
    }

    @GetMapping(path = "/business/payments")
    public String payments(Model model, Integer page, Integer size){
        Pageable pageable = PageRequest.of(page == null ? 0 : page, size == null ? 5 : size);
        Page<TransactionDto> transactionDtoPage = transactionService.findAll(pageable);
        model.addAttribute("transactions", transactionDtoPage.getContent());
        //model.addAttribute("page", transactionDtoPage);
        return "business/payments";
    }

    @GetMapping(path = "/business/users")
    public String users(Model model, Integer page, Integer size){
        Pageable pageable = PageRequest.of(page == null ? 0 : page, size == null ? 5 : size);
        Page<UserDto> userDtoPage = userService.findAll(pageable);
        model.addAttribute("users", userDtoPage.getContent());
        //model.addAttribute("page", userDtoPage);
        return "business/users";
    }

    @GetMapping(path = "/business/addTransaction")
    public String addTransaction(){
        return "business/addTransaction";
    }

    @PostMapping("/business/addTransaction")
    public String register(Model model) {
        try{
            System.out.println(model.getAttribute("dirty_sum")+"  "+model.getAttribute("bonus_ch"));
            model.addAttribute("error", "Transaction was added!");
        }
        catch(Exception e){
            model.addAttribute("error", "Transaction was NOT added!");
        }
        return "redirect:/business/addTransaction";
    }
}
