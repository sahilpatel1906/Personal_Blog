package com.example.blog_api.services;

import com.example.blog_api.models.User;
import com.example.blog_api.repositories.BlogRepository;
import com.example.blog_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
