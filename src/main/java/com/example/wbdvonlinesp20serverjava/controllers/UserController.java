package com.example.wbdvonlinesp20serverjava.controllers;

import com.example.wbdvonlinesp20serverjava.models.User;
import com.example.wbdvonlinesp20serverjava.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin(
        origins = "http://localhost:3000", allowCredentials = "true")
public class UserController {
    @Autowired
    UserRepository repository;

    @PostMapping("/register")
    public User register(
            @RequestBody User user,
            HttpSession session) {
        repository.save(user);
        session.setAttribute("currentUser", user);
        return user;
    }
    @GetMapping("/currentUser")
    public User currentUser(HttpSession session) {
        return (User)session.getAttribute("currentUser");
    }
    @PostMapping("/logout")
    public void logout(HttpSession session) {
        session.invalidate();
    }
    @PostMapping("/login")
    public User login(
            @RequestBody User user,
            HttpSession session) {
        user = repository.findUserByCredentials(user.getUsername(), user.getPassword());
        session.setAttribute("currentUser", user);
        return user;
    }
}
