package com.example.blog_api.models;

public class NewPostDTO {

    private Long blogId;
    private String dateOfCreation;
    private String content;
    private String mediaURL;

    private String title;

    public NewPostDTO(String title, Long blogId, String dateOfCreation, String content, String mediaURL) {
        this.title = title;
        this.blogId = blogId;
        this.dateOfCreation = dateOfCreation;
        this.content = content;
        this.mediaURL = mediaURL;
    }

    public NewPostDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
