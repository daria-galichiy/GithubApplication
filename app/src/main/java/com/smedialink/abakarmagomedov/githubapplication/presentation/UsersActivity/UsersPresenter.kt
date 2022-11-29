package com.smedialink.abakarmagomedov.githubapplication.presentation.UsersActivity

/**
 * Created by abakarmagomedov on 15/05/17.
 */
interface UsersPresenter {
    val users: Unit
    fun attachView(view: UsersView)
    fun detachView()
}
