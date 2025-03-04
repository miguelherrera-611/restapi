package com.api.crud.controllers;

import com.api.crud.model.UserModel;
import com.api.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserModel> fetchAllUsers() {
        return userService.getUsers();
    }

    @PostMapping
    public UserModel addNewUser(@RequestBody UserModel user) {
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public Optional<UserModel> fetchUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public UserModel modifyUser(@RequestBody UserModel userRequest, @PathVariable Long id) {
        return userService.updateUserById(userRequest, id);
    }

    @DeleteMapping("/{id}")
    public String removeUser(@PathVariable Long id) {
        boolean isDeleted = userService.deleteUser(id);
        return isDeleted ? "User with ID " + id + " was deleted." : "Error deleting user with ID " + id;
    }
}
