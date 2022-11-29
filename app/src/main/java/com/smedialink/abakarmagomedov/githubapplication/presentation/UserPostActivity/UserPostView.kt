package com.smedialink.abakarmagomedov.githubapplication.presentation.UserPostActivity

import com.smedialink.abakarmagomedov.githubapplication.data.entity.Repository

/**
 * Created by abakarmagomedov on 15/05/17.
 */
interface UserPostView {
    fun fetchData(reposList: List<Repository>)
    fun showDialog()
    fun hideDialog()
    fun error()
}
