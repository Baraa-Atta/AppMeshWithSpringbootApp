package com.example.aerospikespringboot.controllers;

import com.example.aerospikespringboot.objects.User;
import com.example.aerospikespringboot.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/users/{id}")
    public Optional<User> getUser(@PathVariable(name = "id") Integer id) {
        return userService.readUserById(id);
    }

    @PostMapping(value = "/users")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable(name = "id") Integer id) {
        userService.deleteUserById(id);
    }
}
