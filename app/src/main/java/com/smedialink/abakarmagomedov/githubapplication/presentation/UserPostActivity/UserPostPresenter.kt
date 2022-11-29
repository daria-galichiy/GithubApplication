package com.smedialink.abakarmagomedov.githubapplication.presentation.UserPostActivity

/**
 * Created by abakarmagomedov on 15/05/17.
 */
interface UserPostPresenter {
    fun getRepos(login: String)
    fun attachView(view: UserPostView)
    fun detachView()
}
