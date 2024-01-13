package com.example.socialmedia.data.model;

public class CommentModel {
   private int postId;
    private String name;
   private String email;
   private String body;

    public CommentModel(int postId, String name, String email, String body) {
        this.postId = postId;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    public int getPostId() {
        return postId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBody() {
        return body;
    }
}
