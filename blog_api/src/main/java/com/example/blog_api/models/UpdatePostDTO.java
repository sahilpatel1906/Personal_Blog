package com.example.blog_api.models;

public class UpdatePostDTO {

    private String title;
    private String content;
    private String mediaURL;

    public UpdatePostDTO(String title, String content, String mediaURL) {
        this.title = title;
        this.content = content;
        this.mediaURL = mediaURL;
    }

    public UpdatePostDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
