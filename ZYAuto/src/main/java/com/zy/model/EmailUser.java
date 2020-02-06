package com.zy.model;

public class EmailUser {
    private int id;
    private String email;
    private String name;
    private String comment_note;

    EmailUser(){

    }

    EmailUser(int id,String email,String name,String comment){
        this.id = id;
        this.email = email;
        this.name = name;
        this.comment_note = comment;
    }

    public void setComment(String comment) {
        this.comment_note = comment;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getComment() {
        return comment_note;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}
