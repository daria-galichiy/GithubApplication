package com.smedialink.abakarmagomedov.githubapplication.data.net;

import com.smedialink.abakarmagomedov.githubapplication.data.entity.Repository;
import com.smedialink.abakarmagomedov.githubapplication.data.entity.User;

import java.util.List;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by abakarmagomedov on 15/05/17.
 */

public interface GithubApi {

    @GET("users")
    Observable<List<User>> getUsers();

    @GET("users/{username}/repos")
    Observable<List<Repository>> getUserRepos(@Path("username") String username);

}
