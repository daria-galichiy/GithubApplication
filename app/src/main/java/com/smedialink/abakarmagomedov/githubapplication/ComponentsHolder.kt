package com.smedialink.abakarmagomedov.githubapplication

import android.content.Context
import com.smedialink.abakarmagomedov.githubapplication.di.AppComponent
import com.smedialink.abakarmagomedov.githubapplication.di.UsersComponent
import com.smedialink.abakarmagomedov.githubapplication.di.UserPostComponent
import com.smedialink.abakarmagomedov.githubapplication.di.DaggerAppComponent

/**
 * Created by abakarmagomedov on 15/05/17.
 */
class ComponentsHolder(private val context: Context) {
    lateinit var appComponent: AppComponent
    private var usersComponent: UsersComponent? = null
    private var userPostComponent: UserPostComponent? = null

    fun init() {
        appComponent = DaggerAppComponent.create()
    }

    fun getUsersComponent(): UsersComponent? {
        if (usersComponent == null) {
            usersComponent = appComponent.createUsersComponent()
        }
        return usersComponent
    }

    fun releaseUsersComponent() {
        usersComponent = null
    }

    fun getUserPostComponent(): UserPostComponent? {
        if (userPostComponent == null) {
            userPostComponent = appComponent.createUserPostComponent()
        }
        return userPostComponent
    }

    fun releaseUserPostComponent() {
        userPostComponent = null
    }
}
