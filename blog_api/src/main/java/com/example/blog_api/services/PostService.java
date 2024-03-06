package com.example.blog_api.services;

import com.example.blog_api.models.*;
import com.example.blog_api.repositories.BlogRepository;
import com.example.blog_api.repositories.PostRepository;
import com.example.blog_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    BlogRepository blogRepository;

    @Autowired
    UserRepository userRepository;
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post addPost(NewPostDTO newPostDTO) {
        Optional<Blog> blog = blogRepository.findById(newPostDTO.getBlogId());
        if(blog.isEmpty()){
            return null;
        }
        Post post = new Post(
                newPostDTO.getTitle(),
                blog.get(),
                newPostDTO.getDateOfCreation(),
                newPostDTO.getContent(),
                newPostDTO.getMediaURL()
        );
        return postRepository.save(post);
    }

    public Optional<Post> getPostById(Long id){
        return postRepository.findById(id);
    }


    public Post updatePost(UpdatePostDTO updatePostDTO, Long id) {
       Post updatedPost = postRepository.findById(id).get();

       updatedPost.setTitle(updatePostDTO.getTitle());
       updatedPost.setContent(updatePostDTO.getContent());
       updatedPost.setMediaURL(updatePostDTO.getMediaURL());

       return postRepository.save(updatedPost);
    }


    public void deletePost(Long id) {
       postRepository.delete(getPostById(id).get());
    }

    public Optional<Post> updateLike(Long postId, Long userId){
        Optional<Post> post = postRepository.findById(postId);
        if(post.isEmpty()){
            return Optional.empty();
        }

        Optional<User> user = userRepository.findById(userId);
        if(user.isEmpty()){
            return Optional.empty();
        }

        // Checking if the user has already liked the post
        if(post.get().getUsers().contains(user.get())){
            post.get().removeLike(user.get());
            user.get().removeLikeFromPost(post.get());

            postRepository.save(post.get());
            return post;
        }

        post.get().addLike(user.get());
        user.get().addLikeToPost(post.get());

        postRepository.save(post.get());
        return post;
    }

}
