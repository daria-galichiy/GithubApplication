package com.smedialink.abakarmagomedov.githubapplication.presentation.UserPostActivity

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by abakarmagomedov on 15/05/17.
 */
class UserPostPresenterImp(private val interactor: UserPostInteractor) : UserPostPresenter {
    private var disposable: Disposable? = null
    private var view: UserPostView? = null
    override fun getRepos(login: String) {
        disposable = interactor.loadReposFromGithub(login)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { view?.showDialog() }
            .doOnTerminate { view?.hideDialog() }
            .subscribe({ repositories -> view?.fetchData(repositories) }) { view?.error() }
    }

    override fun attachView(view: UserPostView) {
        this.view = view
    }

    override fun detachView() {
        view = null
        if (disposable?.isDisposed == false) {
            disposable?.dispose()
        }
    }
}
