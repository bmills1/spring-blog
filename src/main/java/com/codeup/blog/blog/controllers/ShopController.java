package com.codeup.blog.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class ShopController {
    @GetMapping("/shop/{name}")
    public String sayHello(@PathVariable String name, Model viewModel) {
        viewModel.addAttribute("name", name);
        return "hello";
    }

    HashMap<String, Boolean> items;

    @GetMapping("/shop")
    @ResponseBody
    public String getItems(@PathVariable HashMap<String, Boolean> items) {


        items.put("shoe", false);
        items.put("book", true);
        items.put("toliet", false);
        items.put("waffle", true);
        items.put("cup", false);
        items.put("carpet", false);
        String html = "";
        for (String key : items.keySet()) {
            html += "<ul><li>" + key + "</li></ul>";
        }
        return html;
    }


    @GetMapping("/sh")
    @ResponseBody
    public String sale(@RequestParam String sale) {
        return sale;
    }
//    @PostMapping("/shop?sale={}")
//    @ResponseBody
//    public String postItems(@PathVariable @RequestParam(required = true) String item){
//        String html = "";
//
//        for (Map.Entry<String, Boolean> entry : items.entrySet()) {
//            if (items.containsValue(true)) {
//                html += entry.getKey();
//            }
//        }
//    return html;
//    }
}
