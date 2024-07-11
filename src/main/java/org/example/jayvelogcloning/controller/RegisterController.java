package org.example.jayvelogcloning.controller;

import lombok.RequiredArgsConstructor;
import org.example.jayvelogcloning.domain.User;
import org.example.jayvelogcloning.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@RequiredArgsConstructor
@Controller
@RequestMapping("/userreg")
public class RegisterController {
    private final UserService userService;

    @GetMapping
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "registerForm";
    }
    @PostMapping
    public String processRegisterForm(@ModelAttribute("user") User user) {
        User regiterdUser = userService.saveUser(user);
        System.out.println(regiterdUser);
        return "redirect:/home";
    }

}
