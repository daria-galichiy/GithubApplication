package com.smedialink.abakarmagomedov.githubapplication.di

import com.smedialink.abakarmagomedov.githubapplication.data.net.GithubApi
import com.smedialink.abakarmagomedov.githubapplication.presentation.UserPostActivity.UserPostInteractor
import com.smedialink.abakarmagomedov.githubapplication.presentation.UserPostActivity.UserPostInteractorImp
import com.smedialink.abakarmagomedov.githubapplication.presentation.UserPostActivity.UserPostPresenter
import com.smedialink.abakarmagomedov.githubapplication.presentation.UserPostActivity.UserPostPresenterImp
import dagger.Module
import dagger.Provides

/**
 * Created by abakarmagomedov on 15/05/17.
 */
@UserPostScope
@Module
class UserPostModule {
    @UserPostScope
    @Provides
    fun provideUserPostPresenter(interactor: UserPostInteractor): UserPostPresenter {
        return UserPostPresenterImp(interactor)
    }

    @UserPostScope
    @Provides
    fun provideUserPostInteractor(api: GithubApi): UserPostInteractor {
        return UserPostInteractorImp(api)
    }
}
