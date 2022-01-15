package com.group.event_notifier;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/organizer")
public class EventOrganizerController {
  @GetMapping
  public String getOrganizer(){
    return "organizer";
  }
  @GetMapping("/detail/{id}")
  public String getOrganizerDetail(){
    return "organizer";
  }

}
