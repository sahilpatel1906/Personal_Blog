package com.example.blog_api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "blog_id")
    @JsonIgnoreProperties({"posts", "user"}) //Ignoring user as well as do not need user info
    private Blog blog;
    @Column
    private String dateOfCreation;
    @Column
    private int likes;
    @Column
    private String content;
    @Column
    private String mediaURL;

    @JsonIgnoreProperties({"post"})
    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

//    CONSTRUCTOR
    public Post(Blog blog, String dateOfCreation, String content, String mediaURL) {

        this.blog = blog;
        this.dateOfCreation = dateOfCreation;
        this.likes = 0;
        this.content = content;
        this.mediaURL = mediaURL;
        this.comments = new ArrayList<>();
    }
// DEFAULT CONSTRUCTOR
    public Post() {
    }

//  GETTERS AND SETTERS
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

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
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

    public void addComment(Comment comment){
        this.comments.add(comment);
    }

    public void removeComment(Comment comment){
        this.comments.remove(comment);
    }
}
