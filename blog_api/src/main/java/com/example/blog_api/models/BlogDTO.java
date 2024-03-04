package com.example.blog_api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;
public class BlogDTO {

    private String name;

    private String dateOfCreation;

    private String timeOfCreation;

    private Long userId;

    public BlogDTO(String name, String dateOfCreation, String timeOfCreation, Long userId) {
        this.name = name;
        this.dateOfCreation = dateOfCreation;
        this.timeOfCreation = timeOfCreation;
        this.userId = userId;
    }

    public BlogDTO(String dateOfCreation) {
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}