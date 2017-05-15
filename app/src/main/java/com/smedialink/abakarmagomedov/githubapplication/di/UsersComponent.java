package com.smedialink.abakarmagomedov.githubapplication.di;

import com.smedialink.abakarmagomedov.githubapplication.presentation.UsersActivity.UsersActivity;

import dagger.Subcomponent;

/**
 * Created by abakarmagomedov on 15/05/17.
 */

@UsersScope
@Subcomponent(modules = {UsersModule.class})
public interface UsersComponent {
    void inject(UsersActivity usersActivity);
}
