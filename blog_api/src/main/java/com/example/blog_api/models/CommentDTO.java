package com.example.blog_api.models;

public class CommentDTO {

    private String text;
    private Post post;
    private Boolean isEdited;

    public CommentDTO(String text, Post post, Boolean isEdited)
    {
        this.text = text;
        this.post = post;
        this.isEdited = isEdited;
    }

    public CommentDTO()
    {

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Boolean getEdited() {
        return isEdited;
    }

    public void setEdited(Boolean edited) {
        isEdited = edited;
    }
}
