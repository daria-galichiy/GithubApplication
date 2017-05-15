package com.smedialink.abakarmagomedov.githubapplication.presentation.UserPostActivity;

import android.util.Log;

import com.smedialink.abakarmagomedov.githubapplication.data.entity.Repository;
import com.smedialink.abakarmagomedov.githubapplication.presentation.UsersActivity.UsersView;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by abakarmagomedov on 15/05/17.
 */

public class UserPostPresenterImp implements UserPostPresenter {

    private Disposable disposable;
    private UserPostView view;
    private final UserPostInteractor interactor;

    public UserPostPresenterImp(UserPostInteractor interactor) {
        this.interactor = interactor;
    }

    @Override
    public void getRepos(String login) {
        disposable = interactor.loadReposFromGithub(login)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable1 -> view.showDialog())
                .doOnTerminate(() -> view.hideDialog())
                .subscribe(repositories -> view.fetchData(repositories), throwable -> view.error());
    }

    @Override
    public void attachView(UserPostView view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
        if(!disposable.isDisposed()){
            disposable.dispose();
        }
    }
}
