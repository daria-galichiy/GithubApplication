package com.smedialink.abakarmagomedov.githubapplication.presentation.UserPostActivity;

import com.smedialink.abakarmagomedov.githubapplication.data.entity.Repository;
import com.smedialink.abakarmagomedov.githubapplication.data.net.GithubApi;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by abakarmagomedov on 15/05/17.
 */

public class UserPostInteractorImp implements UserPostInteractor {

    private final GithubApi api;

    public UserPostInteractorImp(GithubApi api) {
        this.api = api;
    }

    @Override
    public Observable<List<Repository>> loadReposFromGithub(String login) {
        return  api.getUserRepos(login);
    }
}
