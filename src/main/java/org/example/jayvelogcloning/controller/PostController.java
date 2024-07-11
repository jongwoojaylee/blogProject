package org.example.jayvelogcloning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PostController {
    @RequestMapping("/post")
    public String showPostForm(Model model) {
        return "postForm";
    }
    @RequestMapping("/post")
    public String post(Model model) {
        return "redirect:/blog/@"+model.getAttribute("name");
    }

}
