package com.smedialink.abakarmagomedov.githubapplication.presentation.UserPostActivity;

import com.smedialink.abakarmagomedov.githubapplication.data.entity.Repository;
import com.smedialink.abakarmagomedov.githubapplication.data.entity.User;

import java.util.List;

/**
 * Created by abakarmagomedov on 15/05/17.
 */

public interface UserPostView {

    void fetchData(List<Repository> reposList);
    void showDialog();
    void hideDialog();
    void error();

}
