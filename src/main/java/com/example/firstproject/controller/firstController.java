package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class firstController {
    @GetMapping("/hi")
    public String niceToMeetYou(Model model){
        model.addAttribute("usernm", "KDI333");
        return "greeting";
    }

    @GetMapping("/bye")
    public String byeYou(Model model){
        model.addAttribute("nickNm", "KDI333");
        return "bye";
    }
}
