package com.example.blog_api.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "blog_id")
    private Long blogId;
    @Column
    private String dateOfCreation;
    @Column
    private int likes;
    @Column
    private String content;
    @Column
    private String mediaURL;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

//    CONSTRUCTOR
    public Post(Long blogId, String dateOfCreation, int likes, String content, String mediaURL, List<Comment> comments) {

        this.blogId = blogId;
        this.dateOfCreation = dateOfCreation;
        this.likes = likes;
        this.content = content;
        this.mediaURL = mediaURL;
        this.comments = comments;
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

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
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
}
