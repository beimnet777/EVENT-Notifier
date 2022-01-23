package com.group.event_notifier.security;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.Data;

@Data
public class HostRegistrationForm {
    private String organizationName;
    private String username;
    private String password;
    private String email;
    private String streetAddress;
    private String phone;

    Host toHost(PasswordEncoder encoder) {
        Host host = new Host();
        host.setOrganizationName(this.organizationName);
        host.setUsername(this.username);
        host.setPassword(encoder.encode(this.password));
        host.setEmail(this.email);
        host.setStreetAddress(this.streetAddress);
        host.setPhone(this.phone);
        host.setOrganization(true);
        return host;
    }
}