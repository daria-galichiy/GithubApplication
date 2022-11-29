package com.smedialink.abakarmagomedov.githubapplication.presentation.UsersActivity

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SnapHelper
import android.widget.ProgressBar
import com.smedialink.abakarmagomedov.githubapplication.App.Companion.getApp
import com.smedialink.abakarmagomedov.githubapplication.BaseActivity
import com.smedialink.abakarmagomedov.githubapplication.adapters.UsersAdapter
import com.smedialink.abakarmagomedov.githubapplication.adapters.UsersAdapter.UserClickListener
import com.smedialink.abakarmagomedov.githubapplication.data.entity.User
import com.smedialink.abakarmagomedov.githubapplication.databinding.ActivityUsersBinding
import com.smedialink.abakarmagomedov.githubapplication.presentation.UserPostActivity.UserPostActivity
import javax.inject.Inject


class UsersActivity : BaseActivity(), UsersView, UserClickListener {
    @Inject
    lateinit var snapHelper: SnapHelper
    @Inject
    lateinit var presenter: UsersPresenter
    private lateinit var binding: ActivityUsersBinding
    override var mProgressBar: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUsersBinding.inflate(layoutInflater)
        mProgressBar = binding.progressBar
        setContentView(binding.root)
        getApp(this).componentsHolder.getUsersComponent()?.inject(this)
        presenter.attachView(this)
        presenter.users
    }

    override fun error() {
        errorDialog.show()
    }

    override fun showUsers(userList: List<User>) {
        val adapter = UsersAdapter(userList, this)
        binding.usersRecycler.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.usersRecycler.adapter = adapter
        snapHelper.attachToRecyclerView(binding.usersRecycler)
    }

    override fun showDialog() {
        showProgress()
    }

    override fun hideDialog() {
        hideProgress()
    }

    override fun userClicked(login: String) {
        start(UserPostActivity::class.java, login)
    }

    override fun onDestroy() {
        super.onDestroy()
        hideProgress()
        if (isFinishing) {
            presenter.detachView()
            getApp(this).componentsHolder.releaseUsersComponent()
        }
    }
}
