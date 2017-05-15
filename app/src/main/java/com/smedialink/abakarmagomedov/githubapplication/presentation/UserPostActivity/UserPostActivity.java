package com.smedialink.abakarmagomedov.githubapplication.presentation.UserPostActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.smedialink.abakarmagomedov.githubapplication.App;
import com.smedialink.abakarmagomedov.githubapplication.BaseActivity;
import com.smedialink.abakarmagomedov.githubapplication.Constants;
import com.smedialink.abakarmagomedov.githubapplication.R;
import com.smedialink.abakarmagomedov.githubapplication.adapters.PostsAdapter;
import com.smedialink.abakarmagomedov.githubapplication.data.entity.Repository;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserPostActivity extends BaseActivity implements UserPostView, PostsAdapter.RepoClickListener {

    @Inject UserPostPresenter presenter;
    @BindView(R.id.bottomSheet) View bottomSheet;
    @BindView(R.id.repos_recyclerview) RecyclerView reposRecycler;
    @BindView(R.id.forks) TextView forks;
    @BindView(R.id.stars) TextView stars;
    @BindView(R.id.watchers) TextView watchers;
    @BindView(R.id.info) TextView info;
    private PostsAdapter adapter;
    private BottomSheetBehavior mBottomSheetBehavior;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_post);
        ButterKnife.bind(this);
        App.getApp(this).getComponentsHolder().getUserPostComponent().inject(this);
        presenter.attachView(this);
        presenter.getRepos(getIntent().getStringExtra(Constants.LOGIN));
        mBottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
    }

    @Override
    public void fetchData(List<Repository> reposList) {
        adapter = new PostsAdapter(reposList, this);
        reposRecycler.setLayoutManager(new LinearLayoutManager(this));
        reposRecycler.setAdapter(adapter);
    }

    @Override
    public void showDialog() {
        showProgress();
    }

    @Override
    public void hideDialog() {
        hideProgress();
    }

    @Override
    public void error() {
        getErrorDialog().show();
    }


    @Override
    public void userClicked(Integer watchers, Integer forks, Integer stars, String info) {
        this.watchers.setText(String.valueOf(watchers));
        this.forks.setText(forks + "");
        this.stars.setText(stars + "");
        this.info.setText(info);
        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        hideProgress();
        if (isFinishing()) {
            App.getApp(this).getComponentsHolder().releaseUserPostComponent();
            presenter.detachView();
        }
    }


}
