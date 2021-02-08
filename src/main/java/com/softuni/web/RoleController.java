package com.softuni.web;

import com.softuni.model.entity.RoleEnumName;
import com.softuni.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;

@Controller
@RequestMapping("/role")
public class RoleController {

    private final UserService userService;

    public RoleController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("names",this.userService.getAllUsersNames());
        return "role-add";
    }

    @PostMapping("/add")
    public String addConfirm(@RequestParam String username,
                             @RequestParam String role){

        this.userService.changeRole(username,RoleEnumName.valueOf(role.toUpperCase()));

        return "redirect:/";
    }


}
