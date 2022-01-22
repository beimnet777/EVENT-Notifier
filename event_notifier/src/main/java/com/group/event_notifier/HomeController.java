package com.group.event_notifier;


import org.springframework.stereotype.Controller;


import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;



@Data
@Controller

public class HomeController {
    private final HostRepository hostrepo;
    @GetMapping()
    public String getMethodName() {
        
        return "home";
    }
    
    
}
