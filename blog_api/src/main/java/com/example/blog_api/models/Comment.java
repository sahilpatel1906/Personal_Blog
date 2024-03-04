package com.example.blog_api.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    //Many-to-One relationship with Post
    @ManyToOne
    @JsonIgnoreProperties({"comments"})
    @JoinColumn(name = "post_id")
    private Post post;

    @Column(name = "text")
    private String text;

    @Column(name = "is_edited")
    private boolean isEdited;

    @Column(name = "user_name")
    private String userName;

    public Comment(Post post, String text, boolean isEdited, String userName) {
        this.id = id;
        this.post = post;
        this.text = text;
        this.isEdited = isEdited;
        this.userName = userName;
    }

    public Comment() {
    }

    //    GETTERS AND SETTERS


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isEdited() {
        return isEdited;
    }

    public void setEdited(boolean edited) {
        isEdited = edited;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}


