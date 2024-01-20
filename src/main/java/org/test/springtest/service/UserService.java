package org.test.springtest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.test.springtest.entity.User;
import org.test.springtest.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }
    public User getUserByUsername(String userName) {
        return userRepository.findByUsername(userName).orElse(null);
    }
    public String deleteUser(Long userId) {
        userRepository.deleteById(userId);
        return "User removed! "+ userId;
    }
    public User updateUser(User user) {
        User existingUser = userRepository.findById(user.getId()).orElse(null);
        existingUser.setName(user.getName());
        existingUser.setUsername(user.getUsername());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        return userRepository.save(existingUser);
    }
}
