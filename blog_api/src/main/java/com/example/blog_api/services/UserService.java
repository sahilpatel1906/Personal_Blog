package com.example.blog_api.services;

import com.example.blog_api.models.Blog;
import com.example.blog_api.models.NewUserDTO;
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

    @Autowired
    BlogRepository blogRepository;


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(NewUserDTO newUserDTO) {
        User user = new User(newUserDTO.getName(), newUserDTO.getPassword());
        for(Long blogId : newUserDTO.getBlogIds()){
            Blog blog = blogRepository.findById(blogId).get();
            user.addBlog(blog);
        }
        return userRepository.save(user);
    }

    public User findUser(Long id) {
        return userRepository.findById(id).get();
    }
}
