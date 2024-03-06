package com.example.blog_api.controllers;

import com.example.blog_api.models.*;
import com.example.blog_api.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PostMapping
    public ResponseEntity<Post> addNewPost(@RequestBody NewPostDTO newPostDTO){
        Post post = postService.addPost(newPostDTO);
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id){
        Optional<Post> post = postService.getPostById(id);
        if(post.isEmpty()){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(post.get(),HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Post> updatePost(@RequestBody UpdatePostDTO updatePostDTO, @PathVariable Long id){
       Optional<Post> post = postService.getPostById(id);
        if(post.isEmpty()){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        Post updatedPost = postService.updatePost(updatePostDTO, id);
        return new ResponseEntity<>(updatedPost,HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deletePost(@PathVariable Long id){
        postService.deletePost(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PatchMapping(value = "/{postId}/{userId}/likes")
    public ResponseEntity<Post> updateLikes(@PathVariable Long postId, @PathVariable Long userId)
    {
        //Looks for specific post
        Optional<Post> post = postService.updateLike(postId, userId);
        if(post.isPresent()){
            return new ResponseEntity<>(post.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

//    @GetMapping("/{postId}/likes")
//    public ResponseEntity<Long> getLikes(@PathVariable Long postId){
//        Long likeCount = postService.getLikeCount(postId);
//        return new ResponseEntity<>(likeCount, HttpStatus.OK);
//    }
}
