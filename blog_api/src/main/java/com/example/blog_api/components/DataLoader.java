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
        Comment healthComment = new Comment(post7, "Thanks for the tips!", false, user5.getName());
        Comment healthComment1 = new Comment(post7, "I'll incorporate these into my routine", false, user6.getName());
        Comment footballComment = new Comment(post8, "Interesting analysis, I never thought of that", false, user7.getName());
        Comment footballComment1 = new Comment(post8, "Can't wait for the next match breakdown", false, user1.getName());
        Comment movieComment = new Comment(post9, "These movies are classics!", false, user2.getName());
        Comment movieComment1 = new Comment(post9, "I've been meaning to watch these", false, user3.getName());
        Comment comicComment = new Comment(post10, "Love the new series, can't wait for more!", false, user4.getName());
        Comment comicComment1 = new Comment(post10, "The art style is amazing", false, user5.getName());
        Comment fashionComment2 = new Comment(post11, "I'm obsessed with these trends", false, user6.getName());
        Comment fashionComment3 = new Comment(post11, "I need to update my wardrobe ASAP", false, user7.getName());
        Comment fitnessComment2 = new Comment(post12, "Finally, some tips I can use!", false, user1.getName());
        Comment fitnessComment3 = new Comment(post12, "I'll add these exercises to my routine", false, user2.getName());
        Comment travelComment2 = new Comment(post13, "Your stories make me want to travel more", false, user3.getName());
        Comment travelComment3 = new Comment(post13, "Such adventurous experiences!", false, user4.getName());
        Comment bookReviewComment2 = new Comment(post14, "Adding these books to my reading list", false, user5.getName());
        Comment bookReviewComment3 = new Comment(post14, "I've read some of these, they're great recommendations", false, user6.getName());
        Comment diaryBlogComment2 = new Comment(post15, "Your reflections resonate with me", false, user7.getName());
        Comment diaryBlogComment3 = new Comment(post15, "Thanks for sharing your thoughts", false, user1.getName());

        commentRepository.save(fitnessComment);
        commentRepository.save(fitnessComment1);
        commentRepository.save(travelComment);
        commentRepository.save(travelComment1);
        commentRepository.save(fashionComment);
        commentRepository.save(bookReviewComment);
        commentRepository.save(diaryBlogComment);
        commentRepository.save(healthComment);
        commentRepository.save(healthComment1);
        commentRepository.save(footballComment);
        commentRepository.save(footballComment1);
        commentRepository.save(movieComment);
        commentRepository.save(movieComment1);
        commentRepository.save(comicComment);
        commentRepository.save(comicComment1);
        commentRepository.save(fashionComment2);
        commentRepository.save(fashionComment3);
        commentRepository.save(fitnessComment2);
        commentRepository.save(fitnessComment3);
        commentRepository.save(travelComment2);
        commentRepository.save(travelComment3);
        commentRepository.save(bookReviewComment2);
        commentRepository.save(bookReviewComment3);
        commentRepository.save(diaryBlogComment2);
        commentRepository.save(diaryBlogComment3);


        post1.addLike(user1);
        post1.addLike(user2);
        post1.addLike(user3);
        post1.addLike(user4);
        post1.addLike(user5);
        post1.addLike(user6);
        post1.addLike(user7);

        post2.addLike(user2);
        post2.addLike(user3);
        post2.addLike(user4);
        post2.addLike(user5);
        post2.addLike(user6);

        post3.addLike(user3);
        post3.addLike(user4);
        post3.addLike(user5);
        post3.addLike(user6);
        post3.addLike(user7);

        post4.addLike(user4);
        post4.addLike(user5);
        post4.addLike(user6);

        post5.addLike(user5);
        post5.addLike(user6);
        post5.addLike(user7);

        post6.addLike(user6);
        post6.addLike(user7);
        post6.addLike(user1);

        post7.addLike(user7);
        post7.addLike(user1);
        post7.addLike(user2);

        post8.addLike(user1);
        post8.addLike(user2);
        post8.addLike(user3);

        post9.addLike(user2);
        post9.addLike(user3);
        post9.addLike(user4);

        post10.addLike(user3);
        post10.addLike(user4);
        post10.addLike(user5);

        post11.addLike(user4);
        post11.addLike(user5);
        post11.addLike(user6);

        post12.addLike(user5);
        post12.addLike(user6);
        post12.addLike(user7);

        post13.addLike(user6);
        post13.addLike(user7);
        post13.addLike(user1);

        post14.addLike(user7);
        post14.addLike(user1);
        post14.addLike(user2);

        post15.addLike(user1);
        post15.addLike(user2);
        post15.addLike(user3);

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
    }
}

