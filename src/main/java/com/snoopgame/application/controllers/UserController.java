package com.snoopgame.application.controllers;

import com.snoopgame.application.Entities.Role;
import com.snoopgame.application.Entities.User;
import com.snoopgame.application.Repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.Map;

@RequestMapping("/registration")
@Controller
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public String registration() {
        return "registration";
    }

    @PostMapping
    public String addUser(User user, Model model) {
        User userFromDb = userRepository.findByUsername(user.getUsername());
        if (userFromDb != null) {
            model.addAttribute("message", "User exists!");
            return "registration";
        }
        user.setRoles(Collections.singleton(Role.ADMIN));
        user.setActive(true);
        userRepository.save(user);
        return "redirect:/login";
    }
}
