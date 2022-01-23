package com.group.event_notifier.security;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/signup/host")
public class HostRegistrationController {
    private final HostRepository hostRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping
    public String hostRegisterForm(){
        return "Host-signup";
    }

    @PostMapping
    public String hostProcessRegistration(HostRegistrationForm hostForm) {
        hostRepository.save(hostForm.toHost(passwordEncoder));
        return "redirect:/make_events";
    }

}

