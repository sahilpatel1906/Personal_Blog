package com.example.blog_api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column
    private String password;

    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties({"user", "dateOfCreation", "timeOfCreation", "posts"})
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Blog> blogs;

    // Posts a user has liked
    @ManyToMany(mappedBy = "users")
    @JsonIgnore
    private List<Post> posts;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        this.blogs = new ArrayList<>();
        this.posts = new ArrayList<>();
    }

    public User() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    public List<Post> getPosts(){
        return this.posts;
    }

    public void setPosts(List<Post> posts){
        this.posts = posts;
    }

    // ADDITIONAL METHODS

    public void addBlog(Blog blog){
        this.blogs.add(blog);
    }

    public void removeBlog(Blog blog){
        this.blogs.remove(blog);
    }

    public User save(User userToUpdate) {
        return userToUpdate;
    }

    public void addLikedPostToUser(Post post){
        this.posts.add(post);
    }

    public void removeLikedPostFromUser(Post post){
        this.posts.remove(post);
    }
}
