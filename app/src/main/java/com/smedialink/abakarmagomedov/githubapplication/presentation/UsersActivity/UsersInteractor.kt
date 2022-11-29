package com.smedialink.abakarmagomedov.githubapplication.presentation.UsersActivity

import com.smedialink.abakarmagomedov.githubapplication.data.entity.User
import io.reactivex.Observable

/**
 * Created by abakarmagomedov on 15/05/17.
 */
interface UsersInteractor {
    fun loadUsersFromGit(): Observable<List<User>>
}
