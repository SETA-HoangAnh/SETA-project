package com.example.studydemo.service.Impl;

import com.example.studydemo.entity.Users;
import com.example.studydemo.exception.NotFoundException;
import com.example.studydemo.repository.UserRepository;
import com.example.studydemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<Users> getUser(String userName, String userAddress) {
        if(userName == null) {
            userName = "";
        }
        if(userAddress == null) {
            userAddress = "";
        }
        return userRepository.getUser(userName, userAddress);
    }

    @Override
    public void addUser(Users user) {
        userRepository.save(user);
    }

    @Override
    public void editUser(Long userId ,Users user) {

        Users userFind = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User not found"));
        userFind.setUserName(user.getUserName());
        userFind.setUserAddress(user.getUserAddress());
        userRepository.save(userFind);
    }

    @Override
    public void deleteUser(Long userId) {

        Users userFind = userRepository.findById(userId)
                .orElseThrow(()-> new NotFoundException("User Not Found"));
        userRepository.delete(userFind);
    }
}
