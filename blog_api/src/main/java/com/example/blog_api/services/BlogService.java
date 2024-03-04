package com.example.blog_api.services;

import com.example.blog_api.models.Blog;
import com.example.blog_api.models.BlogDTO;
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

//    public Optional<Blog> addBlog(BlogDTO blogDTO) {
//        User user =
//        Blog newBlog = new Blog(blogDTO.getName(), blogDTO.getDateOfCreation(), blogDTO.getTimeOfCreation(), )
//    }
}
