package com.example.socialmedia.data.remote;

import com.example.socialmedia.data.model.CommentModel;
import com.example.socialmedia.data.model.PostModel;

import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WebServices {
    @GET("posts")
    Call<ArrayList<PostModel>> getPosts();
    @GET("comments")
    Call<ArrayList<CommentModel>> getComments(@Query("postId") int postId);
}
