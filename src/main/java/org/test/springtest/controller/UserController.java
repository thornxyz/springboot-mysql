package org.test.springtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.test.springtest.entity.User;
import org.test.springtest.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @GetMapping("/findById/{userId}")
    public User getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }
    @GetMapping("/findByName/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    @DeleteMapping("/delete/{userId}")
    public String deleteUser(@PathVariable Long userId) {
        return userService.deleteUser(userId);
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }
}
