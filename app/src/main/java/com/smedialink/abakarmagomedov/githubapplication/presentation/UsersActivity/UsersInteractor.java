package com.smedialink.abakarmagomedov.githubapplication.presentation.UsersActivity;


import com.smedialink.abakarmagomedov.githubapplication.data.entity.User;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by abakarmagomedov on 15/05/17.
 */

public interface UsersInteractor {
    Observable<List<User>> loadUsersFromGit();
}
