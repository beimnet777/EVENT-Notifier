package com.group.event_notifier;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String adminControl(Model model){
      List<User> users =new ArrayList<>();
        userRepo.findAll().forEach(i->users.add(i));
        model.addAttribute("USERS", users);
      List<Host> uhost = new ArrayList<>(); //unapproved host
      List<Host> vhost = new ArrayList<>();  // approved host 
      hostRepo.findAll().forEach(i->{
        if(i.isOrganization()){
          vhost.add(i);
        }
        else{
          uhost.add(i);
        }
      });
      model.addAttribute("UHOST", uhost);
      model.addAttribute("VHOST", vhost);
        return "admin";
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
    


    @GetMapping("/updateEvent")
    public String updateEvent (){
      List<Event> events = new ArrayList<>();
      this.eventRepo.findAll().forEach(i->events.add(i));
      String date = new Date().toString();
      for(Event i: events){
        if (i.getEndingDate().compareTo(date) <0){
          OldEvent oldEvent= new OldEvent(
            i.getId(),
            i.getEventName(),
            i.getType1(),
            i.getType2(),
            i.getType3(),
            i.getType4(),
            i.getType5(),
            i.getEventDescription(),
            i.getEndingDate(),
            i.getLocation(),
            i.getImgDirectory(),
            i.getOrganizationId()
          );
          
          eventRepo.deleteById(i.getId());
          oldEventRepo.save(oldEvent);
        }
      }
      return "redirec:/admin";

    }

}
