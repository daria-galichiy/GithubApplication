package com.smedialink.abakarmagomedov.githubapplication.presentation.UserPostActivity;

import com.smedialink.abakarmagomedov.githubapplication.data.entity.Repository;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by abakarmagomedov on 15/05/17.
 */

public interface UserPostInteractor {

    Observable<List<Repository>> loadReposFromGithub(String login);
}
