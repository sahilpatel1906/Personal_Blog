package com.example.blog_api.models;

import jakarta.persistence.*;

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
    private Long userId;

    @OneToMany(mappedBy = "blog")
    private List<Post> posts;

    public Blog(Long id, String name, String dateOfCreation, String timeOfCreation, Long userId, List<Post> posts) {
        this.id = id;
        this.name = name;
        this.dateOfCreation = dateOfCreation;
        this.timeOfCreation = timeOfCreation;
        this.userId = userId;
        this.posts = posts;
    }

    public Blog() {
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

    public long getUser() {
        return userId;
    }

    public void setUser(Long userId) {
        this.userId = userId;
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
