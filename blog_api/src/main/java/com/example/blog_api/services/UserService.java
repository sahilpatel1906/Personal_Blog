package com.example.blog_api.services;

import com.example.blog_api.models.*;
import com.example.blog_api.repositories.BlogRepository;
import com.example.blog_api.repositories.CommentRepository;
import com.example.blog_api.repositories.PostRepository;
import com.example.blog_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BlogRepository blogRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(NewUserDTO newUserDTO) {
        User user = new User(newUserDTO.getName(), newUserDTO.getPassword());
        return userRepository.save(user);
    }

    public User findUser(Long id) {
        return userRepository.findById(id).get();
    }

    public User updateUser(NewUserDTO newUserDTO, Long id) {
        User userToUpdate = userRepository.findById(id).get();
        userToUpdate.setName(newUserDTO.getName());
        userToUpdate.setPassword(newUserDTO.getPassword());

        return userRepository.save(userToUpdate);
    }

    public void deleteUser(Long id) {
        User user = userRepository.findById(id).get();
        for (Blog blog : user.getBlogs()){
            for (Post post : blog.getPosts()){
                post.getComments().clear();
                postRepository.save(post);
//                for (Comment comment : post.getComments()){
//
//                }
            }
            blog.getPosts().clear();
            blogRepository.save(blog);
        }
        user.getBlogs().clear();
        userRepository.delete(user);
    }
}
