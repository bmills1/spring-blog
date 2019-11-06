package com.codeup.blog.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class TestColor {
    @GetMapping("/testcolor")
    public String showColorForm() {
        return "testcolor";
    }

    @PostMapping("/testcolor")
    public String getOrg(@RequestParam(name = "branch") String branch, Model model){

        model.addAttribute("branch", branch);

        return "testpage";
    }
}
