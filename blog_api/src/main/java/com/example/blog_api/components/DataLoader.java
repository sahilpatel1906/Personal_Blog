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

    public DataLoader() {
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        User user1 = new User("Mike", "password");
        User user2 = new User("Nick", "password");
        User user3 = new User("Amy", "password");
        User user4 = new User("Katie", "password");
        User user5 = new User("Jen", "password");
        User user6 = new User("Steve", "password");
        User user7 = new User("John", "password");

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);
        userRepository.save(user5);
        userRepository.save(user6);
        userRepository.save(user7);

        Blog fitnessBlog = new Blog("Fitness Blog", "17/03/24", "15:00", user1);
        Blog travelBlog = new Blog("Travel Blog", "11/11/24", "15:00", user1);
        Blog fashionBlog = new Blog("Fashion Blog", "02/01/24", "15:00", user1);

        Blog bookReviewBlog = new Blog("Book Review", "16/09/24", "19:00", user2);
        Blog diaryBlog = new Blog("Diary Blog", "14/10/24", "11:00", user2);

        Blog footballBlog = new Blog("Football Weekly", "16/02/24", "19:00", user3);
        Blog healthBlog = new Blog("Live for Longer", "14/01/24", "11:00", user3);

        Blog movieBlog = new Blog("Movie Reviews", "01/09/22", "19:00", user4);
        Blog comicBlog = new Blog("Comic Central", "14/10/24", "11:00", user4);

        blogRepository.save(fitnessBlog);
        blogRepository.save(travelBlog);
        blogRepository.save(fashionBlog);
        blogRepository.save(bookReviewBlog);
        blogRepository.save(diaryBlog);
        blogRepository.save(footballBlog);
        blogRepository.save(healthBlog);
        blogRepository.save(movieBlog);
        blogRepository.save(comicBlog);


        Post post1 = new Post("Weight Loss Journey", fitnessBlog, "15/05/24", "My 5 Workout Routines to lose Weight!", null);
        Post post2 = new Post("Travel places",travelBlog, "10/01/24", "My 5 Fav places to Travel", "https://static.independent.co.uk/2023/08/02/10/iStock-507489863.jpg");
        Post post3 = new Post("Best places",travelBlog, "06/02/24", "Most expensive places to visit", null);
        Post post4 = new Post("Fashionable",fashionBlog, "09/11/24", "The Smart Casual Look", null);
        Post post5 = new Post("Book Review",bookReviewBlog, "09/11/24", "My Top 10 books of 2023", null);
        Post post6 = new Post("My Diary",diaryBlog, "09/11/24", "Diary entry 103", null);
        Post post7 = new Post("Healthy Habits", healthBlog, "20/02/24", "5 Tips for a Healthier Lifestyle", "https://example.com/image7.jpg");
        Post post8 = new Post("Football Tactics", footballBlog, "22/03/24", "Analyzing the Latest Strategies", "https://example.com/image8.jpg");
        Post post9 = new Post("Movie Recommendations", movieBlog, "05/10/22", "Must-Watch Films of the Year", null);
        Post post10 = new Post("Comic Review", comicBlog, "18/11/24", "Exploring the Latest Comic Releases", "https://example.com/image9.jpg");
        Post post11 = new Post("Favorite Fashion Trends", fashionBlog, "03/02/24", "Trendy Outfit Ideas for the Season", "https://example.com/image11.jpg");
        Post post12 = new Post("Fitness Tips", fitnessBlog, "28/05/24", "Effective Exercises for Building Muscle", "https://example.com/image12.jpg");
        Post post13 = new Post("Adventure Stories", travelBlog, "15/03/24", "Exciting Tales from Around the Globe", "https://example.com/image13.jpg");
        Post post14 = new Post("Book Recommendation", bookReviewBlog, "30/11/24", "A Must-Read Novel for Bookworms", "https://example.com/image14.jpg");
        Post post15 = new Post("Reflecting on Life", diaryBlog, "02/12/24", "Thoughts on Recent Experiences", "https://example.com/image15.jpg");

        postRepository.save(post1);
        postRepository.save(post2);
        postRepository.save(post3);
        postRepository.save(post4);
        postRepository.save(post5);
        postRepository.save(post6);
        postRepository.save(post7);
        postRepository.save(post8);
        postRepository.save(post9);
        postRepository.save(post10);
        postRepository.save(post11);
        postRepository.save(post12);
        postRepository.save(post13);
        postRepository.save(post14);
        postRepository.save(post15);

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

