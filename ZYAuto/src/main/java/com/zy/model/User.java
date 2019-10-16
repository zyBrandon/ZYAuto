package com.zy.model;

public class User {
    private int id;
    private String username;
    private String pass;
    private String email;
    private String role;

    public User(){

    }

    public User(int id,String username,String pass,String email,String role){
        this.id = id;
        this.username = username;
        this.pass = pass;
        this.email = email;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }

    public String getRole() {
        return role;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
