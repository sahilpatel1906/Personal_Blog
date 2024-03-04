package com.example.blog_api.services;

import com.example.blog_api.models.CommentDTO;
import com.example.blog_api.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    //@Autowired
    CommentRepository commentRepository;

    //Gets a list of all comments
    public List getAllComments()
    {
        return commentRepository.findAll();
    }

    public void newComment(CommentDTO commentDTO)
    {

    }




}
