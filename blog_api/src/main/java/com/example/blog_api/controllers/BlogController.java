package com.example.blog_api.controllers;

import com.example.blog_api.models.Blog;
import com.example.blog_api.models.BlogDTO;
import com.example.blog_api.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<Blog> addBlog(@RequestBody BlogDTO blogDTO){
        Blog newBlog = blogService.addBlog(blogDTO);
        return new ResponseEntity<>(newBlog, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable Long id){
        Optional<Blog> blog = blogService.getById(id);
        if(blog.isPresent()){
            return new ResponseEntity<>(blog.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

//    @PutMapping(value = "/{id}")
//    public ResponseEntity<Blog> updateBlog(@RequestBody BlogDTO blogDTO){
//
//    }
}
