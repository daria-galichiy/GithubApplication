package com.smedialink.abakarmagomedov.githubapplication;

import android.content.Context;

import com.smedialink.abakarmagomedov.githubapplication.di.AppComponent;
import com.smedialink.abakarmagomedov.githubapplication.di.AppModule;
import com.smedialink.abakarmagomedov.githubapplication.di.DaggerAppComponent;
import com.smedialink.abakarmagomedov.githubapplication.di.UserPostComponent;
import com.smedialink.abakarmagomedov.githubapplication.di.UsersComponent;

/**
 * Created by abakarmagomedov on 15/05/17.
 */

public class ComponentsHolder {

    private final Context context;

    private AppComponent appComponent;
    private UsersComponent usersComponent;
    private UserPostComponent userPostComponent;

    public ComponentsHolder(Context context) {
        this.context = context;
    }

    void init(){
        appComponent = DaggerAppComponent.create();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public UsersComponent getUsersComponent(){
        if(usersComponent == null){
            usersComponent = getAppComponent().createUsersComponent();
        }
        return usersComponent;
    }

    public void releaseUsersComponent(){
        usersComponent = null;
    }

    public UserPostComponent getUserPostComponent(){
        if(userPostComponent == null){
            userPostComponent = getAppComponent().createUserPostComponent();
        }
        return userPostComponent;
    }

    public void releaseUserPostComponent(){
        userPostComponent = null;
    }
}
