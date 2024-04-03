package com.example.blog_api.services;

import com.example.blog_api.models.*;
import com.example.blog_api.repositories.BlogRepository;
import com.example.blog_api.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    BlogRepository blogRepository;

    @Autowired
    PostService postService;

    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    public Blog addBlog(NewBlogDTO newBlogDTO) {
        Optional<User> user = userRepository.findById(newBlogDTO.getUserId());
        if(user.isPresent()) {
            Blog newBlog = new Blog(newBlogDTO.getName(), newBlogDTO.getDateOfCreation(), newBlogDTO.getTimeOfCreation(), user.get());
            return blogRepository.save(newBlog);
        }
        return null;
    }

    public Optional<Blog> getById(Long id) {
        return blogRepository.findById(id);
    }

    public Optional<Blog> updateBlog(UpdateBlogDTO updateBlogDTO, Long id){
        Optional<Blog> blogToUpdate = blogRepository.findById(id);
        if(blogToUpdate.isEmpty()){
            return Optional.empty();
        }

        blogToUpdate.get().setName(updateBlogDTO.getName());
        blogToUpdate.get().setDateOfCreation(updateBlogDTO.getDateOfCreation());
        blogToUpdate.get().setTimeOfCreation(updateBlogDTO.getTimeOfCreation());
        blogRepository.save(blogToUpdate.get());

        return blogToUpdate;
    }

    @Transactional
    public void deleteBlog(Long id) {
        Optional<Blog> blog = blogRepository.findById(id);
        if(blog.isPresent()) {
            Blog blogToDelete = blog.get();
            List<Post> posts = blogToDelete.getPosts();
            for(Post post : posts){
                postService.deletePost(post.getId());
            }
            blogRepository.delete(blog.get());
        }
    }
}
