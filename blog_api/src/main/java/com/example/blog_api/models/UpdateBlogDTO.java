package com.example.blog_api.models;

public class UpdateBlogDTO {

    private String name;

    private String dateOfCreation;

    private String timeOfCreation;

    private Long blogId;

    // Constructor for adding new blog
    public UpdateBlogDTO(String name, String dateOfCreation, String timeOfCreation, Long blogId) {
        this.name = name;
        this.dateOfCreation = dateOfCreation;
        this.timeOfCreation = timeOfCreation;
        this.blogId = blogId;
    }

    public UpdateBlogDTO() {
    }

    //    GETTERS AND SETTERS


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

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }
}