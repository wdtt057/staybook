package com.wdt.staybook.controller;

import com.wdt.staybook.entity.User;
import com.wdt.staybook.entity.UserRole;
import com.wdt.staybook.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {
    private RegisterService registerService;

    @Autowired
    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping("/register/guest")
    public void addGuest(@RequestBody User user) {
        registerService.add(user, UserRole.ROLE_GUEST);
    }

//    @PostMapping("/register/guest")
//    public void addGuest() {
//        User user = new User.Builder("Vincent", "adb123").build();
//        registerService.add(user, UserRole.ROLE_GUEST);
//    }

    @PostMapping("/register/host")
    public void addHost(@RequestBody User user) {
        registerService.add(user, UserRole.ROLE_HOST);
    }
}
