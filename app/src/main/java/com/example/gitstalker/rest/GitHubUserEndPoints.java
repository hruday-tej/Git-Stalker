package com.example.gitstalker.rest;

import com.example.gitstalker.model.GitHubRepo;
import com.example.gitstalker.model.GitHubUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubUserEndPoints {

//    {users} it is the data that we have to send dynamically thats why we are using @Path for it...
//    @Path("text") String/int/.. "text2" the path will replace the text with text2.. i.e variable substitution...
    @GET("/users/{user}")
    Call<GitHubUser> getUser(@Path("user") String user);

    @GET("/users/{user}/repos")
    Call<List<GitHubRepo>> getRepo(@Path("user") String name);
}
