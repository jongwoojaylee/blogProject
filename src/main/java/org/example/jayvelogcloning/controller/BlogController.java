package org.example.jayvelogcloning.controller;

import lombok.RequiredArgsConstructor;
import org.example.jayvelogcloning.domain.Blog;
import org.example.jayvelogcloning.domain.User;
import org.example.jayvelogcloning.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
public class BlogController {
    private final UserService userService;


    @RequestMapping("/{username}")
    public String blog(@PathVariable String username, Model model) {
        if(!username.startsWith("@")){
            return "incorrectUser";
        }else {
            username = username.substring(1);
            User user = userService.findUserByUsername(username);
            if(user == null){
                return "incorrectUser";
            }
            model.addAttribute("user", user);

            Blog blog = user.getBlog();
            model.addAttribute("blog", blog);
            return "blog";
        }
    }
}
