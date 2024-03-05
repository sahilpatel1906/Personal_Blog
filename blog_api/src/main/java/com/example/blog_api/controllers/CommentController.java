package com.example.blog_api.controllers;

import com.example.blog_api.models.Comment;
import com.example.blog_api.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/comments")
public class CommentController {

    @Autowired
    CommentService commentService;
    //Gets a list of all comments
    @GetMapping
    public ResponseEntity<List<Comment>>getAllComments()
    {
        List<Comment>comments;
        comments = commentService.getAllComments();
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }





}
