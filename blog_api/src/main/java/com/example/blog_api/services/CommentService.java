package com.example.blog_api.services;

import com.example.blog_api.models.Comment;
import com.example.blog_api.models.CommentDTO;
import com.example.blog_api.models.Post;
import com.example.blog_api.models.User;
import com.example.blog_api.repositories.CommentRepository;
import com.example.blog_api.repositories.PostRepository;
import com.example.blog_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PostRepository postRepository;
    @Autowired
    UserService userService;

    //Gets a list of all comments
    public List<Comment> getAllComments()
    {
        return commentRepository.findAll();
    }

    //Creates a new comment in Post
    public void addComment(CommentDTO commentDTO)
    {
        //Finds username using userId
        String username = userService.findUser(commentDTO.getUserId()).getName();
        //Finding post by its post id
        Post post = postRepository.findById(commentDTO.getPostId()).get();
        //Created Comment object
        Comment comment = new Comment(
                post,
                commentDTO.getText(),
                commentDTO.getEdited(),
                username);
        //Created a comment that shows username
        //If post and user exists, save the comment
        if (post != null && username != null)
            commentRepository.save(comment);
    }


    //Gets a comment by id
    public Comment getCommentById(Long id)
    {
        return commentRepository.getById(id);
    }

    //Updates a specific comment
    public void updateComment(CommentDTO commentDTO, long id) // updated comment
    {
        //Finding post by its post id
        Post post = postRepository.findById(commentDTO.getPostId()).get();
        //Finding comment by its comment id
        Comment comment = commentRepository.findById(id).get();
        //If comment has not been edited before
        if (commentDTO.getEdited().equals(false)){
        Comment updatedComment = commentRepository.findById(id).get();
        updatedComment.setText(commentDTO.getText());
        updatedComment.setEdited(true);
        updatedComment.getUserName();
        }
    }

    //Deletes a specific comment
    public void deleteCommentById(Long id)
    {
        commentRepository.delete(getCommentById(id));
    }

}
