package com.smedialink.abakarmagomedov.githubapplication.presentation.UsersActivity

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by abakarmagomedov on 15/05/17.
 */
class UsersPresenterImp @Inject constructor(private val interactor: UsersInteractor) :
    UsersPresenter {
    private var disposable: Disposable? = null
    private var view: UsersView? = null
    override val users: Unit
        get() {
            disposable = interactor.loadUsersFromGit()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { view?.showDialog() }
                .doOnTerminate { view?.hideDialog() }
                .subscribe({ users -> view?.showUsers(users) }) { view?.error() }
        }

    override fun attachView(view: UsersView) {
        this.view = view
    }

    override fun detachView() {
        view = null
        if (disposable?.isDisposed == false) {
            disposable?.dispose()
        }
    }
}
