package com.example.studydemo.controller;

import com.example.studydemo.entity.Users;
import com.example.studydemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("${apiPrefix}/users")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    public ResponseEntity<List<Users>> getUsers(@RequestParam(required = false) String userName,
                                      @RequestParam(required = false) String userAddress) {

        List<Users> userFind =userService.getUser(userName, userAddress);
        return new ResponseEntity<>(userFind, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<String> createUser(@RequestBody Users user) {

        userService.addUser(user);
        return ResponseEntity.ok("User created");
    }

    @PutMapping("/{userId}")
    public ResponseEntity<String> updateUser(@PathVariable("userId") Long userId,
                                        @RequestBody Users user) {

        userService.editUser(userId, user);
        return ResponseEntity.ok("User edited");
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable("userId") Long userId) {

        userService.deleteUser(userId);
        return ResponseEntity.ok("User deleted");
    }
}
