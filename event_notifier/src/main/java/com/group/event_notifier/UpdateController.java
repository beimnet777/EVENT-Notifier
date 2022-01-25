package com.group.event_notifier;

import com.group.event_notifier.security.User;
import com.group.event_notifier.security.UserRepository;
import com.group.event_notifier.security.Host;
import com.group.event_notifier.security.HostRepository;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;

import lombok.Data;

@Data
@RequestMapping("/profile")
@Controller
public class UpdateController {
  private final UserRepository userRepo;
  private final HostRepository hostRepo; 
  @GetMapping("/user")
  public String showProfile(Model model,@AuthenticationPrincipal User user ){
    model.addAttribute(("user"), user);
    return "user_profile";
  }
  @GetMapping("/host")
  public String showProfile(Model model,@AuthenticationPrincipal Host host ){
    model.addAttribute(("host"), host);
    return "host_profile";
  }
  @PutMapping("/update/user")
public String updateUser(User user){
  userRepo.save(user);
  return "redirect:/profile/user";
} 
  
}
