package com.example.blog_api.models;

public class NewPostDTO {

    private Long blogId;
    private String dateOfCreation;
    private String content;
    private String mediaURL;

    public NewPostDTO(Long blogId, String dateOfCreation, String content, String mediaURL) {
        this.blogId = blogId;
        this.dateOfCreation = dateOfCreation;
        this.content = content;
        this.mediaURL = mediaURL;
    }

    public NewPostDTO() {
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

    public String getContent() {
        return content;
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
}
