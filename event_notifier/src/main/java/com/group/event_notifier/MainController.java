package com.group.event_notifier;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/mainPage")
public class MainController {
    @GetMapping("/forYou")
    public String fetchForYou(){
        return "forYou";
    }
    @GetMapping("/featured")
    public String fetchAroundYou(){
        return "featured";
    }
    
}
