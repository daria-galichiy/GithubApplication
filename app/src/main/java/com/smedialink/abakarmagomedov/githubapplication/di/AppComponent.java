package com.smedialink.abakarmagomedov.githubapplication.di;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by abakarmagomedov on 15/05/17.
 */

@Singleton
@Component(modules = {AppModule.class, NetModule.class, UtilsModule.class})
public interface AppComponent {

    UsersComponent createUsersComponent();
    UserPostComponent createUserPostComponent();

}
