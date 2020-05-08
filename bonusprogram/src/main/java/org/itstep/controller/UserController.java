package org.itstep.controller;

import org.itstep.service.UserService;
import org.itstep.service.dto.UserDto;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
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
    public String account() {
        return "user/account";
    }

    @PostMapping("/user/register")
    public String register(@Validated @ModelAttribute UserDto userDto,
                           BindingResult bindingResult, Model model) {
        userDto.setRole("ROLE_USER");
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult);
            return "index";
        }
        try {
            userService.save(userDto);
        } catch (Exception e) {
            userDto.setPassword("");
            model.addAttribute("errorLogin", "Try again");
            return "index";
        }
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        userDto.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));

        SecurityContext emptyContext = SecurityContextHolder.createEmptyContext();
        emptyContext.setAuthentication(new UsernamePasswordAuthenticationToken(userDto, userDto.getPassword(),
                AuthorityUtils.createAuthorityList(userDto.getRole())));
        SecurityContextHolder.setContext(emptyContext);
        return "redirect:/user/account";
    }
}
