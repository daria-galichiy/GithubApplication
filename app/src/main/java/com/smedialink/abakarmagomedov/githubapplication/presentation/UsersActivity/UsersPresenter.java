package com.smedialink.abakarmagomedov.githubapplication.presentation.UsersActivity;

/**
 * Created by abakarmagomedov on 15/05/17.
 */

public interface UsersPresenter {

    void getUsers();
    void attachView(UsersView view);
    void detachView();

}
