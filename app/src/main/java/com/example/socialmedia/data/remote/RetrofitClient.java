package com.example.socialmedia.data.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class RetrofitClient {
    static String BASE_URL="https://jsonplaceholder.typicode.com/";
    static Retrofit retrofit;
   public static WebServices getService(){
        if(retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(WebServices.class);
    }
}
