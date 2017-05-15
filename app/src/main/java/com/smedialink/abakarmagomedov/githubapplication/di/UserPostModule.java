package com.smedialink.abakarmagomedov.githubapplication.di;

import com.smedialink.abakarmagomedov.githubapplication.data.net.GithubApi;
import com.smedialink.abakarmagomedov.githubapplication.presentation.UserPostActivity.UserPostInteractor;
import com.smedialink.abakarmagomedov.githubapplication.presentation.UserPostActivity.UserPostInteractorImp;
import com.smedialink.abakarmagomedov.githubapplication.presentation.UserPostActivity.UserPostPresenter;
import com.smedialink.abakarmagomedov.githubapplication.presentation.UserPostActivity.UserPostPresenterImp;

import dagger.Module;
import dagger.Provides;

/**
 * Created by abakarmagomedov on 15/05/17.
 */

@UserPostScope
@Module
public class UserPostModule {


    @UserPostScope
    @Provides
    UserPostPresenter provideUserPostPresenter(UserPostInteractor interactor) {
        return new UserPostPresenterImp(interactor);
    }

    @UserPostScope
    @Provides
    UserPostInteractor provideUserPostInteractor(GithubApi api){
        return new UserPostInteractorImp(api);
    }

}
