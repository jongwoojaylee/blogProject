package org.example.jayvelogcloning.controller;

import lombok.RequiredArgsConstructor;
import org.example.jayvelogcloning.domain.Blog;
import org.example.jayvelogcloning.domain.User;
import org.example.jayvelogcloning.repository.BlogRepository;
import org.example.jayvelogcloning.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
public class BlogController {
    private final BlogRepository blogRepository;
    private final UserRepository userRepository;

    @RequestMapping("/{name}")
    public String blog(@PathVariable String name, Model model) {
        if(!name.startsWith("@")){
            return "incorrectUser";
        }else {
            name = name.substring(1);
            User user = userRepository.findByName(name).orElse(null);
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
