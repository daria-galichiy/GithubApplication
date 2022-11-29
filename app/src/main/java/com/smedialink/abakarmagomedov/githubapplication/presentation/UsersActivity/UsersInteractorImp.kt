package com.smedialink.abakarmagomedov.githubapplication.presentation.UsersActivity

import com.smedialink.abakarmagomedov.githubapplication.data.entity.User
import com.smedialink.abakarmagomedov.githubapplication.data.net.GithubApi
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by abakarmagomedov on 15/05/17.
 */
class UsersInteractorImp @Inject constructor(private val api: GithubApi) : UsersInteractor {
    override fun loadUsersFromGit(): Observable<List<User>> {
        return api.getUsers()
    }
}
