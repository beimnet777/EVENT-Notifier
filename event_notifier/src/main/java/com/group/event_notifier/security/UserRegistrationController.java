package com.group.event_notifier.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserRegistrationController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/signup/user")
    public String userRegisterForm() {
        return "User-Signup";
    }

    @PostMapping("/signup/user")
    public String userProcessRegistration(UserRegistrationForm userForm) {
        userRepository.save(userForm.toUser(passwordEncoder));
        return "redirect:/mainPage";
    }
}
