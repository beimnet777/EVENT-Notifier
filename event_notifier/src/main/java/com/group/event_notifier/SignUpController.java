package com.group.event_notifier;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.Data;

@Controller
@Data
@RequestMapping("/signUp")
public class SignUpController {
    private final UserRepository userRepo;
    private final HostRepository hostRepo;
    @GetMapping("/user")
    public String signUser(Model model){

        User user = new User();
        model.addAttribute("USER", user);
        return "signUp";
    }
    @PostMapping("/user")
    public String registerUser (User user,Model model){
        model.addAttribute("USER", user);
        userRepo.save(user);
        return "redirect:/login";
    }
    @GetMapping("/host")  
    public String signHost(Model model,Host host){
        
        model.addAttribute("HOST",host);
        return "signup";
    }
    @PostMapping("/host")
    public String registerHost(Model model,Host host ){
       
        model.addAttribute("HOST", host);
        hostRepo.save(host);

        return "redirect:/";
    }
    
}