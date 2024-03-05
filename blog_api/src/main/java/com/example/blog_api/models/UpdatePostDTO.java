package com.example.blog_api.models;

public class UpdatePostDTO {

    private String content;
    private String mediaURL;

    public UpdatePostDTO(String content, String mediaURL) {
        this.content = content;
        this.mediaURL = mediaURL;
    }

    public UpdatePostDTO() {
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
