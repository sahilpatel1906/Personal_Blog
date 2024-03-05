package com.example.blog_api.models;

import java.util.List;

public class NewUserDTO {

    private String name;
    private String password;
    private List<Long> blogIds;

    public NewUserDTO(String name, String password, List<Long> blogIds){
        this.name = name;
        this.password = password;
        this.blogIds = blogIds;
    }

    public NewUserDTO(){
    }

//    GETTERS AND SETTERS

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

    public List<Long> getBlogIds() {
        return blogIds;
    }

    public void setBlogIds(List<Long> blogIds) {
        this.blogIds = blogIds;
    }
}
