package com.smedialink.abakarmagomedov.githubapplication.di

import com.smedialink.abakarmagomedov.githubapplication.presentation.UsersActivity.UsersInteractor
import com.smedialink.abakarmagomedov.githubapplication.presentation.UsersActivity.UsersInteractorImp
import com.smedialink.abakarmagomedov.githubapplication.presentation.UsersActivity.UsersPresenter
import com.smedialink.abakarmagomedov.githubapplication.presentation.UsersActivity.UsersPresenterImp
import dagger.Binds
import dagger.Module

/**
 * Created by abakarmagomedov on 15/05/17.
 */
@Module
interface UsersModule {
    @UsersScope
    @Binds
    fun provideUsersPresenter(interactor: UsersPresenterImp): UsersPresenter

    @UsersScope
    @Binds
    fun provideUsersInteractor(interactor: UsersInteractorImp): UsersInteractor
}
