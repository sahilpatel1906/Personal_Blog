package com.example.blog_api.components;

import com.example.blog_api.models.Blog;
import com.example.blog_api.models.Comment;
import com.example.blog_api.models.Post;
import com.example.blog_api.models.User;
import com.example.blog_api.repositories.BlogRepository;
import com.example.blog_api.repositories.CommentRepository;
import com.example.blog_api.repositories.PostRepository;
import com.example.blog_api.repositories.UserRepository;
import com.example.blog_api.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    BlogRepository blogRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        User user1 = new User("Mike", "password");
        User user2 = new User("Nick", "password");
        User user3 = new User("Amy", "password");
        User user4 = new User("Katie", "password");

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);

        Blog fitnessBlog = new Blog("Fitness Blog", "17/03/24", "15:00", user1);
        Blog travelBlog = new Blog("Travel Blog", "11/11/24", "15:00", user1);
        Blog fashionBlog = new Blog("Fashion Blog", "02/01/24", "15:00", user1);
        Blog bookReviewBlog = new Blog("Book Review", "16/09/24", "15:00", user1);
        Blog diaryBlog = new Blog("Diary Blog", "14/10/24", "15:00", user1);

        blogRepository.save(fitnessBlog);
        blogRepository.save(travelBlog);
        blogRepository.save(fashionBlog);
        blogRepository.save(bookReviewBlog);
        blogRepository.save(diaryBlog);

        Post post1 = new Post(fitnessBlog, "15/05/24", 5, "My 5 Workout Routines to lose Weight!", "image 1");
        Post post2 = new Post(travelBlog, "10/01/24", 10, "My 5 Fav places to Travel", "image 4");
        Post post3 = new Post(travelBlog, "06/02/24", 1080, "Most expensive places to visit", "image 2");
        Post post4 = new Post(fashionBlog, "09/11/24", 45, "The Smart Casual Look", "image 1");
        Post post5 = new Post(bookReviewBlog, "09/11/24", 45, "My Top 10 books of 2023", "image 1");
        Post post6 = new Post(diaryBlog, "09/11/24", 45, "Diary entry 103", "image 1");

        postRepository.save(post1);
        postRepository.save(post2);
        postRepository.save(post3);
        postRepository.save(post4);
        postRepository.save(post5);
        postRepository.save(post6);

        Comment fitnessComment = new Comment(post1, "Great will try this out", false, user1.getName());
        Comment fitnessComment1 = new Comment(post1, "Boring ...", false, user2.getName());
        Comment travelComment = new Comment(post2, "Will visit Morocco soon!", false, user3.getName());
        Comment travelComment1 = new Comment(post3, "Been there before, hated it", false, user3.getName());
        Comment fashionComment = new Comment(post4,"where did you get those shoes from", false, user4.getName());
        Comment bookReviewComment = new Comment(post5, "I've read up to page 60", false, user1.getName());
        Comment diaryBlogComment = new Comment(post6, "Wow, really interesting", false, user2.getName());

        commentRepository.save(fitnessComment);
        commentRepository.save(fitnessComment1);
        commentRepository.save(travelComment);
        commentRepository.save(travelComment1);
        commentRepository.save(fashionComment);
        commentRepository.save(bookReviewComment);
        commentRepository.save(diaryBlogComment);
    }
}
