package com.example.blog_api.services;

import com.example.blog_api.models.Blog;
import com.example.blog_api.models.NewBlogDTO;
import com.example.blog_api.models.UpdateBlogDTO;
import com.example.blog_api.models.User;
import com.example.blog_api.repositories.BlogRepository;
import com.example.blog_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    BlogRepository blogRepository;

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
            return null;
        }

        blogToUpdate.get().setName(updateBlogDTO.getName());
        blogToUpdate.get().setDateOfCreation(updateBlogDTO.getDateOfCreation());
        blogToUpdate.get().setTimeOfCreation(updateBlogDTO.getTimeOfCreation());
        blogRepository.save(blogToUpdate.get());

        return blogToUpdate;
    }
}
