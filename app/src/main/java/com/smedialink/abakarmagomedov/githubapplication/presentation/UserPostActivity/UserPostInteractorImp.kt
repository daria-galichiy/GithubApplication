package com.smedialink.abakarmagomedov.githubapplication.presentation.UserPostActivity

import com.smedialink.abakarmagomedov.githubapplication.data.entity.Repository
import com.smedialink.abakarmagomedov.githubapplication.data.net.GithubApi
import io.reactivex.Observable

/**
 * Created by abakarmagomedov on 15/05/17.
 */
class UserPostInteractorImp(private val api: GithubApi) : UserPostInteractor {
    override fun loadReposFromGithub(login: String): Observable<List<Repository>> {
        return api.getUserRepos(login)
    }
}
