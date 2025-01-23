package com.example.JournalApp.controller;

import com.example.JournalApp.cache.AppCache;
import com.example.JournalApp.entity.User;
import com.example.JournalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService  userService;

    @Autowired
    private AppCache appCache;

    @GetMapping("/all-users")
    public ResponseEntity<?> getAllUsers() {
        List<User> allUsers = userService.getAllUsers();
        if (allUsers != null && !allUsers.isEmpty()) {
            return new ResponseEntity<>(allUsers, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create-admin-user")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        try {
            userService.saveAdmin(user);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }


    @GetMapping("/clear-app-cache")
    public void clearAppCache() {
        appCache.init();
    }
}
