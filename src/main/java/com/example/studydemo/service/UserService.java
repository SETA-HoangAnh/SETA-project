package com.example.studydemo.service;

import com.example.studydemo.entity.Users;

import java.util.List;

public interface UserService {

    List<Users> getUser(String username, String userAddress);

    void addUser(Users user);

    void editUser(Long userId ,Users user);

    void deleteUser(Long userId);
}
