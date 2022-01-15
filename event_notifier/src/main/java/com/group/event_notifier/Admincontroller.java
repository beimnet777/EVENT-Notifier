package com.group.event_notifier;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;

@RequestMapping("/admin")
@Controller
public class Admincontroller {
  @GetMapping
    public String adminControl(){
        return "adminControl";
    }
    @GetMapping("/users")
    public String showUsers(){
      return "users";
    }
    @GetMapping("/users/deleteAccount")
    public String deleteAccount(){
      return "deleteAccount";
    }
    @DeleteMapping("/users/deleteAccount/{id}")
    public String deleteUser(){
      return "redirect:/users";
    }
    @GetMapping("/hosts")
    public String showHosts(){
      return "hosts";
    }

}
