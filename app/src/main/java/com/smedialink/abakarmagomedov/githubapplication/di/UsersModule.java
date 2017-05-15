package com.smedialink.abakarmagomedov.githubapplication.di;

import com.smedialink.abakarmagomedov.githubapplication.data.net.GithubApi;
import com.smedialink.abakarmagomedov.githubapplication.presentation.UsersActivity.UsersInteractor;
import com.smedialink.abakarmagomedov.githubapplication.presentation.UsersActivity.UsersInteractorImp;
import com.smedialink.abakarmagomedov.githubapplication.presentation.UsersActivity.UsersPresenter;
import com.smedialink.abakarmagomedov.githubapplication.presentation.UsersActivity.UsersPresenterImp;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * Created by abakarmagomedov on 15/05/17.
 */

@Module
public interface UsersModule {

    @UsersScope
    @Binds
    UsersPresenter provideUsersPresenter(UsersPresenterImp interactor);

    @UsersScope
    @Binds
    UsersInteractor provideUsersInteractor(UsersInteractorImp interactor);

}
