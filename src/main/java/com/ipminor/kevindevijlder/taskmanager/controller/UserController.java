package com.ipminor.kevindevijlder.taskmanager.controller;

import com.ipminor.kevindevijlder.taskmanager.dto.CreateUserDTO;
import com.ipminor.kevindevijlder.taskmanager.model.User;
import com.ipminor.kevindevijlder.taskmanager.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //navigatie
    @GetMapping
    public String getIndex(Model model){
        return "index";

    }

    @GetMapping("/login")
    public String getLoginForm() {
        return "login";
    }

    @GetMapping("/signup")
    public String getCreateUser(Model model) {
        model.addAttribute("user", new CreateUserDTO());
        return "signupform";
    }

    @PostMapping("/signup")
    public String postCreateUser(@ModelAttribute("user") @Valid CreateUserDTO user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "signupform";
        } else {
            if(userService.createUser(user) == true){
                model.addAttribute("globalerroruseralreadyexists", true);
                return "signupform";
            }
            userService.createUser(user);
            return "redirect:/login";
        }
    }

    @RequestMapping("/403")
    public String accessDenied() {
        return "errors403";
    }
}
