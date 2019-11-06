package com.codeup.blog.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "<h1>Hello</h1>";
    }

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name, Model viewModel) {
        viewModel.addAttribute("name", name);
        return "hello";
    }

    @RequestMapping(path = "/increment/{number}", method = RequestMethod.GET)
    @ResponseBody
    public String addOne(@PathVariable int number) {
        return number + " plus one is " + (number + 1) + "!";
    }


    @GetMapping("/join")
    public String showJoinForm() {
        return "join";
    }

    @PostMapping("/join")
    public String joinCohort(@RequestParam(name = "cohort") String cohort, Model model, @RequestParam(name="branch") String branch) {
        ArrayList students = new ArrayList<>();
        students.add("Mark");
        students.add("Juan");
        students.add("Lisa");
        model.addAttribute("cohort", "Welcome to " + cohort + "!");
        model.addAttribute("students", students);
        model.addAttribute("branch", branch);

        return "join";
    }




}
