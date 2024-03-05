package com.example.blog_api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "blogs")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "date_of_creation")
    private String dateOfCreation;

    @Column(name = "time_of_creation")
    private String timeOfCreation;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties({"blogs"})
    private User user;

    @OneToMany(mappedBy = "blog")
    @JsonIgnoreProperties({"blog"})
    private List<Post> posts;

    public Blog() {
    }

    public Blog(String name, String dateOfCreation, String timeOfCreation, User user){
        this.name = name;
        this.dateOfCreation = dateOfCreation;
        this.timeOfCreation = timeOfCreation;
        this.user = user;
        this.posts = new ArrayList<>();
    }

    //    GETTERS AND SETTERS


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(String dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public String getTimeOfCreation() {
        return timeOfCreation;
    }

    public void setTimeOfCreation(String timeOfCreation) {
        this.timeOfCreation = timeOfCreation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    //  Additional Methods
    public void addPost(Post post){
        this.posts.add(post);
    }

    public void removePost(Post post){
        this.posts.remove(post);
    }
}
