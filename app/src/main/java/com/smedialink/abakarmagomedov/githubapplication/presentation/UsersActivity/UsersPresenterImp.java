package com.smedialink.abakarmagomedov.githubapplication.presentation.UsersActivity;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by abakarmagomedov on 15/05/17.
 */

public class UsersPresenterImp implements UsersPresenter {

    private Disposable disposable;
    private final UsersInteractor interactor;
    private UsersView view;

    @Inject
    public UsersPresenterImp(UsersInteractor interactor) {
        this.interactor = interactor;
    }

    @Override
    public void getUsers() {
        disposable = interactor.loadUsersFromGit()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable1 -> view.showDialog())
                .doOnTerminate(() -> view.hideDialog())
                .subscribe(users -> view.showUsers(users), throwable -> view.error());
    }

    @Override
    public void attachView(UsersView view) {
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
