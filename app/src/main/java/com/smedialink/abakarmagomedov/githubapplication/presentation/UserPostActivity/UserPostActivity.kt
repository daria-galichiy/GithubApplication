package com.smedialink.abakarmagomedov.githubapplication.presentation.UserPostActivity

import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.v7.widget.LinearLayoutManager
import android.widget.ProgressBar
import com.smedialink.abakarmagomedov.githubapplication.App.Companion.getApp
import com.smedialink.abakarmagomedov.githubapplication.BaseActivity
import com.smedialink.abakarmagomedov.githubapplication.Constants
import com.smedialink.abakarmagomedov.githubapplication.adapters.PostsAdapter
import com.smedialink.abakarmagomedov.githubapplication.adapters.PostsAdapter.RepoClickListener
import com.smedialink.abakarmagomedov.githubapplication.data.entity.Repository
import com.smedialink.abakarmagomedov.githubapplication.databinding.ActivityUserPostBinding
import javax.inject.Inject


class UserPostActivity : BaseActivity(), UserPostView, RepoClickListener {
    @Inject
    lateinit var presenter: UserPostPresenter
    private lateinit var adapter: PostsAdapter
    private lateinit var mBottomSheetBehavior: BottomSheetBehavior<*>
    private lateinit var binding: ActivityUserPostBinding
    override var mProgressBar: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserPostBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getApp(this).componentsHolder.getUserPostComponent()?.inject(this)
        presenter.attachView(this)
        intent.getStringExtra(Constants.LOGIN)?.let { presenter.getRepos(it) }
        mBottomSheetBehavior = BottomSheetBehavior.from(binding.bottomSheet)
    }

    override fun fetchData(reposList: List<Repository>) {
        adapter = PostsAdapter(reposList, this)
        binding.reposRecyclerview.layoutManager = LinearLayoutManager(this)
        binding.reposRecyclerview.adapter = adapter
    }

    override fun showDialog() {
        showProgress()
    }

    override fun hideDialog() {
        hideProgress()
    }

    override fun error() {
        errorDialog.show()
    }

    override fun userClicked(watchers: Int?, forks: Int?, stars: Int?, info: String?) {
        binding.watchers.text = watchers.toString()
        binding.forks.text = forks.toString()
        binding.stars.text = stars.toString()
        binding.info.text = info
        mBottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
    }

    override fun onDestroy() {
        super.onDestroy()
        hideProgress()
        if (isFinishing) {
            getApp(this).componentsHolder.releaseUserPostComponent()
            presenter.detachView()
        }
    }
}
