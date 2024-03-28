package com.example.blog_api.services;

import com.example.blog_api.models.*;
import com.example.blog_api.repositories.PostRepository;
import com.example.blog_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

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

    public void deleteUser(Long id){
        User user = userRepository.findById(id).get();
        // Remove posts a user has liked
        removeLikedPostsFromUser(user);
        // Remove the likes on the users posts
        List<Blog> blogs = user.getBlogs();
        for(Blog blog : blogs){
            for(Post post : blog.getPosts()){
                postRepository.delete(post);
            }
        }
        userRepository.delete(user);
    }

    public void removeLikedPostsFromUser(User user){
        for(Post post : user.getPosts()){
            post.removeLike(user);
        }
    }
}
