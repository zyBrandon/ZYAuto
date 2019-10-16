package com.zy.model;

public class UserURL {
    private int id;
    private String username;
    private String url;
    public UserURL(){

    }
    public UserURL(int id,String username,String url){
        this.id = id;
        this.username = username;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
