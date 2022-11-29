package com.smedialink.abakarmagomedov.githubapplication.di

import dagger.Component
import javax.inject.Singleton

/**
 * Created by abakarmagomedov on 15/05/17.
 */
@Singleton
@Component(modules = [AppModule::class, NetModule::class, UtilsModule::class])
interface AppComponent {
    fun createUsersComponent(): UsersComponent
    fun createUserPostComponent(): UserPostComponent
}
