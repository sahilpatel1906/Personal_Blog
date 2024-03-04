package com.example.blog_api.services;

import com.example.blog_api.repositories.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogService {

    @Autowired
    BlogRepository blogRepository;
}
