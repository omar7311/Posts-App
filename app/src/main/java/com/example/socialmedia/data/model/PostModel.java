package com.example.socialmedia.data.model;

public class PostModel {
    private int id;
    private String title;
    private String body;

    public PostModel(int id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public String getBody() {
        return body;
    }
}
