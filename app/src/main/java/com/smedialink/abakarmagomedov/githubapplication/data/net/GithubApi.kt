package com.smedialink.abakarmagomedov.githubapplication.data.net

import com.smedialink.abakarmagomedov.githubapplication.data.entity.Repository
import com.smedialink.abakarmagomedov.githubapplication.data.entity.User
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by abakarmagomedov on 15/05/17.
 */
interface GithubApi {
    @GET("users")
    fun getUsers(): Observable<List<User>>

    @GET("users/{username}/repos")
    fun getUserRepos(@Path("username") username: String): Observable<List<Repository>>
}
