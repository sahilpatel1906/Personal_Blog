package com.example.blog_api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @ManyToOne
    @JoinColumn(name = "blog_id")
    @JsonIgnoreProperties({"posts", "user", "dateOfCreation", "timeOfCreation"}) //Ignoring user as well as do not need user info
    private Blog blog;
    @Column
    private String dateOfCreation;

    // Users who have liked
    @ManyToMany
    @JoinTable(
            name = "likes",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    @JsonIgnore
    private List<User> users;
    @Column
    private String content;
    @Column(name = "media_URL")
    private String mediaURL;

    private int numberOfLikes;

    @JsonIgnoreProperties({"post", "id","isEdited"})
    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

//    CONSTRUCTOR
    public Post(String title, Blog blog, String dateOfCreation, String content, String mediaURL) {
        this.title = title;
        this.blog = blog;
        this.dateOfCreation = dateOfCreation;
        this.users = new ArrayList<>();
        this.content = content;
        this.mediaURL = mediaURL;
        this.comments = new ArrayList<>();
    }
// DEFAULT CONSTRUCTOR
    public Post() {
    }

//  GETTERS AND SETTERS

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public String getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(String dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public List<User> getUsers() {
        return this.users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMediaURL() {
        return mediaURL;
    }

    public void setMediaURL(String mediaURL) {
        this.mediaURL = mediaURL;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public int getNumberOfLikes(){
        return this.users.size();
    }

    public void addComment(Comment comment){
        this.comments.add(comment);
    }

    public void removeComment(Comment comment){
        this.comments.remove(comment);
    }

    public void addLike(User user){
        this.users.add(user);
    }

    public void removeLike(User user){
        this.users.remove(user);
    }
}
