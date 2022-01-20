package com.group.event_notifier;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import lombok.Data;

@RequestMapping("/admin")
@Controller
@Data
public class AdminController {
  private final UserRepository userRepo;
  private final HostRepository hostRepo;
  private final EventRepository eventRepo;
  private final OldEventRepository oldEventRepo;
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
    public String deleteUser(@Param (value="id") String id){
      userRepo.deleteById(id);
      return "redirect:/users";
    }
    @GetMapping("/hosts")
    public String showHosts(){
      return "hosts";
    }
    @GetMapping("/updateEvent")
    public String updateEvent (){
      List<Event> events = new ArrayList<>();
      this.eventRepo.findAll().forEach(i->events.add(i));
      Date date = new Date();
      for(Event i: events){
        if (i.getEndingDate().compareTo(date) <0){
          OldEvent oldEvent= new OldEvent();
          eventRepo.deleteById(i.getId());
          oldEventRepo.save(oldEvent);
        }
      }
      return "redirec:/admin";

    }

}
