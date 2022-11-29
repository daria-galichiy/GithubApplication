package com.smedialink.abakarmagomedov.githubapplication.presentation.UsersActivity

import com.smedialink.abakarmagomedov.githubapplication.data.entity.User

/**
 * Created by abakarmagomedov on 15/05/17.
 */
interface UsersView {
    fun error()
    fun showUsers(userList: List<User>)
    fun showDialog()
    fun hideDialog()
}
