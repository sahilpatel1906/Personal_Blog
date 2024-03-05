package com.example.blog_api.controllers;

import com.example.blog_api.models.Comment;
import com.example.blog_api.models.CommentDTO;
import com.example.blog_api.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    //Create a new comment
    @PostMapping
    public ResponseEntity<Comment> addNewComment(@RequestBody CommentDTO commentDTO)
    {
        Comment newComment = commentService.addComment(commentDTO);
        return new ResponseEntity<>(newComment, HttpStatus.CREATED);
    }

    //Gets comment by its id
    @GetMapping(value = "/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable Long id) {
        Optional<Comment> comment = commentService.getCommentById(id);
        if (comment.isPresent()) {
            return new ResponseEntity<>(comment.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long id, @RequestBody CommentDTO commentDTO)
    {
        if (commentService.getCommentById(id).isPresent())
        {
            Comment comment = commentService.updateComment(commentDTO, id);
            return new ResponseEntity<>(comment, HttpStatus.OK);
        }
        else return null;
    }


    /*Deletes a specific comment
    @DeleteMapping(value = "/{id}")
    public ResponseEntity
    */

}
