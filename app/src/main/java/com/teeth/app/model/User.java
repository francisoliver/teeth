package com.teeth.app.model;


import com.google.gson.Gson;

public class User {
    String username;
    String mobile;
    String firstName;
    String lastName;
    String password;
    String token;

    public User() {    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String serialize() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    static public User create(String serializedData) {
        Gson gson = new Gson();
        return gson.fromJson(serializedData, User.class);
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }
}