package org.itstep.controller;

import lombok.extern.slf4j.Slf4j;
import org.itstep.repositories.UserRepository;
import org.itstep.service.TransactionService;
import org.itstep.service.UserService;
import org.itstep.service.dto.UserDto;
import org.itstep.service.security.SecurityService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class UserController {
    private final UserService userService;
    private final TransactionService transactionService;
    private final SecurityService securityService;
    private final UserRepository userRepository;

    public UserController(UserService userService, SecurityService securityService, TransactionService transactionService, UserRepository userRepository) {
        this.userService = userService;
        this.securityService = securityService;
        this.transactionService = transactionService;
        this.userRepository = userRepository;
    }

    @GetMapping(path = "/user/enter")
    public String ent() {
        return "user/enter";
    }

    @GetMapping(path = "/user/register")
    public String reg() {
        return "user/register";
    }

    @GetMapping(path = "/user/account")
    public String account(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails){
            String username = ((UserDetails)principal).getUsername();
            model.addAttribute("firstName", userRepository.findUserByPhone(username).getFirstName());
            model.addAttribute("lastName", userRepository.findUserByPhone(username).getLastName());
        }
        return "user/account";
    }

    @PostMapping("/user/register")
    public String register(@Validated @ModelAttribute UserDto userDto,
                           BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            log.error(bindingResult.toString());
            return "/user/register";
        }
        if (securityService.register(userDto) == null) {
            userDto.setRole("ROLE_USER");
            userDto.setPassword("");
            model.addAttribute("errorLogin", "Try again");
            return "index";
        }
        return "redirect:/user/account";
    }




}
