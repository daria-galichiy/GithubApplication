package com.smedialink.abakarmagomedov.githubapplication.presentation.UsersActivity;

import com.smedialink.abakarmagomedov.githubapplication.data.entity.User;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
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
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable1) throws Exception {
                        view.showDialog();
                    }
                })
                .doOnTerminate(new Action() {
                    @Override
                    public void run() {
                        view.hideDialog();
                    }
                })
                .subscribe(new Consumer<List<User>>() {
                    @Override
                    public void accept(List<User> users) throws Exception {
                        view.showUsers(users);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        view.error();
                    }
                });
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
