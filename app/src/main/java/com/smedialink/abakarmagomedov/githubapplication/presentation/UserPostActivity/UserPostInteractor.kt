package com.smedialink.abakarmagomedov.githubapplication.presentation.UserPostActivity

import com.smedialink.abakarmagomedov.githubapplication.data.entity.Repository
import io.reactivex.Observable

/**
 * Created by abakarmagomedov on 15/05/17.
 */
interface UserPostInteractor {
    fun loadReposFromGithub(login: String): Observable<List<Repository>>
}
