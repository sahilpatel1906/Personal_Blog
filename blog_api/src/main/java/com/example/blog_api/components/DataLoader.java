package com.example.blog_api.components;

import com.example.blog_api.models.Blog;
import com.example.blog_api.models.Comment;
import com.example.blog_api.models.Post;
import com.example.blog_api.models.User;

public class DataLoader {

    User user1 = new User("Mike", "mynameismike123");

    Blog fitnessBlog = new Blog("Fitness Blog", "17/03/24", "15:00", user1);


    Post post1 = new Post(fitnessBlog, "15/05/24", 5, "My 5 Workout Routines to lose Weight!", "image 1");
    Post post2 = new Post(fitnessBlog, "15/05/24", 5, "My 5 Workout Routines to lose Weight!", "image 1");
    Post post3 = new Post(fitnessBlog, "15/05/24", 5, "My 5 Workout Routines to lose Weight!", "image 1");



}
