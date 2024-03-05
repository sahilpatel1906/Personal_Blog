package com.example.blog_api.controllers;

import com.example.blog_api.models.NewUserDTO;
import com.example.blog_api.models.Post;
import com.example.blog_api.models.User;
import com.example.blog_api.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("posts")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> getPosts(){
        List<Post> posts = postService.getAllPosts();
        if (!posts.isEmpty()) {
            return new ResponseEntity<>(posts, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

//    @PostMapping("/posts")
//    public ResponseEntity<Post> postPost(@RequestBody NewUserDTO newUserDTO){
//        User user = postService.saveUser(newUserDTO);
//        return new ResponseEntity<>(user, HttpStatus.CREATED);
//    }
}
