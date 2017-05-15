package com.smedialink.abakarmagomedov.githubapplication.presentation.UsersActivity;

import com.smedialink.abakarmagomedov.githubapplication.data.entity.User;
import com.smedialink.abakarmagomedov.githubapplication.data.net.GithubApi;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by abakarmagomedov on 15/05/17.
 */

public class UsersInteractorImp implements UsersInteractor {

    private final GithubApi api;

    @Inject
    public UsersInteractorImp(GithubApi api) {
        this.api = api;
    }

    @Override
    public Observable<List<User>> loadUsersFromGit() {
        return api.getUsers();
    }

}
