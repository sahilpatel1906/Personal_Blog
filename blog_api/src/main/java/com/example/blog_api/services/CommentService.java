package com.example.blog_api.services;

import com.example.blog_api.models.Comment;
import com.example.blog_api.models.CommentDTO;
import com.example.blog_api.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    //@Autowired
    CommentRepository commentRepository;

    //Gets a list of all comments
    public List<Comment> getAllComments()
    {
        return commentRepository.findAll();
    }

    //Creates a new comment
    //public ...


    //Gets a comment by id
    public Comment getCommentById(Long id)
    {
        return commentRepository.getById(id);
    }





}
