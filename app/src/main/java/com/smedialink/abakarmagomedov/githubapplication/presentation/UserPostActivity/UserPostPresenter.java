package com.smedialink.abakarmagomedov.githubapplication.presentation.UserPostActivity;

import com.smedialink.abakarmagomedov.githubapplication.presentation.UsersActivity.UsersView;

/**
 * Created by abakarmagomedov on 15/05/17.
 */

public interface UserPostPresenter {

    void getRepos(String login);
    void attachView(UserPostView view);
    void detachView();
}
