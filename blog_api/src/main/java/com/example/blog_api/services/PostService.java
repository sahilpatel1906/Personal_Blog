package com.example.blog_api.services;

import com.example.blog_api.models.*;
import com.example.blog_api.repositories.BlogRepository;
import com.example.blog_api.repositories.PostRepository;
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
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post addPost(NewPostDTO newPostDTO) {
        Optional<Blog> blog = blogRepository.findById(newPostDTO.getBlogId());
        if(blog.isEmpty()){
            return null;
        }
        Post post = new Post(
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
       updatedPost.setContent(updatePostDTO.getContent());
       updatedPost.setMediaURL(updatedPost.getMediaURL());
       return postRepository.save(updatedPost);
    }


    public void deletePost(Long id) {
       postRepository.delete(getPostById(id).get());
    }
}
