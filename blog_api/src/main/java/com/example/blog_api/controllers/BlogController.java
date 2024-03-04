package com.example.blog_api.controllers;

import com.example.blog_api.models.Blog;
import com.example.blog_api.models.BlogDTO;
import com.example.blog_api.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/blogs")
public class BlogController {

    @Autowired
    BlogService blogService;

    @GetMapping
    public ResponseEntity<List<Blog>> getAllBlogs(){
        List<Blog> blogs = blogService.getAllBlogs();
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

//    @PostMapping
//    public ResponseEntity<Blog> addBlog(BlogDTO blogDTO){
//        Optional<Blog> newBlog = blogService.addBlog(blogDTO);
//        return new ResponseEntity<>(newBlog, HttpStatus.CREATED);
//    }
}
