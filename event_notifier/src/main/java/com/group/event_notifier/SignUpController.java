package com.group.event_notifier;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signUp")
public class SignUpController {
    @GetMapping("/user")
    public String signUser(){
        return "signUp";
    }
    @PostMapping("/signUp")
    public String registerUser (User user){
        return "redirect:/login";
    }
    @GetMapping("/host")
    public String signHost(){
      return "signUp";
    }
    @PostMapping("/host")
    public String registerHost(Host host){
        return "redirect:/login";
    }
    
}