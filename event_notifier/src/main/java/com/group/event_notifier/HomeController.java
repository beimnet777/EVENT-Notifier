package com.group.event_notifier;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;



@Data
@Controller

public class HomeController {
    private final HostRepository hostrepo;
    @GetMapping()
    public String getMethodName(Model model) {
        List<Host> host= new ArrayList<>();
        this.hostrepo.findAll().forEach(i->host.add(i));
        model.addAttribute("HOST", host);
        return "home";
    }
    
    
}
