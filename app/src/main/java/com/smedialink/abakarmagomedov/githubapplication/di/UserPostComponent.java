package com.smedialink.abakarmagomedov.githubapplication.di;

import com.smedialink.abakarmagomedov.githubapplication.presentation.UserPostActivity.UserPostActivity;

import dagger.Subcomponent;

/**
 * Created by abakarmagomedov on 15/05/17.
 */

@UserPostScope
@Subcomponent(modules = {UserPostModule.class})
public interface UserPostComponent {
    void inject(UserPostActivity userPostActivity);
}
