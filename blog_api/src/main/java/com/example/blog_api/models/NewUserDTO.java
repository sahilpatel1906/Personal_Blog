package com.example.blog_api.models;


public class NewUserDTO {

    private String name;
    private String password;

    public NewUserDTO(String name, String password){
        this.name = name;
        this.password = password;
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
}
