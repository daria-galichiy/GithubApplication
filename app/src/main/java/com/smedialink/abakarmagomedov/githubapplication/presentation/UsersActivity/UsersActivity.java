package com.smedialink.abakarmagomedov.githubapplication.presentation.UsersActivity;

import android.app.ProgressDialog;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.widget.Adapter;

import com.smedialink.abakarmagomedov.githubapplication.App;
import com.smedialink.abakarmagomedov.githubapplication.BaseActivity;
import com.smedialink.abakarmagomedov.githubapplication.R;
import com.smedialink.abakarmagomedov.githubapplication.SnappyRecyclerView;
import com.smedialink.abakarmagomedov.githubapplication.adapters.UsersAdapter;
import com.smedialink.abakarmagomedov.githubapplication.data.entity.User;
import com.smedialink.abakarmagomedov.githubapplication.di.UserPostModule;
import com.smedialink.abakarmagomedov.githubapplication.presentation.UserPostActivity.UserPostActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;

public class UsersActivity extends BaseActivity implements UsersView, UsersAdapter.UserClickListener {

    @Inject SnapHelper snapHelper;
    @Inject UsersPresenter presenter;
    @BindView(R.id.users_recycler) SnappyRecyclerView userRecycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        ButterKnife.bind(this);
        App.getApp(this).getComponentsHolder().getUsersComponent().inject(this);
        presenter.attachView(this);
        presenter.getUsers();
    }

    @Override
    public void error() {
        getErrorDialog().show();
    }

    @Override
    public void showUsers(List<User> userList) {
        UsersAdapter adapter = new UsersAdapter(userList, this);
        userRecycle.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        userRecycle.setAdapter(adapter);
        snapHelper.attachToRecyclerView(userRecycle);
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
    public void userClicked(String login) {
        start(UserPostActivity.class, login);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        hideProgress();
        if (isFinishing()) {
            presenter.detachView();
            App.getApp(this).getComponentsHolder().releaseUsersComponent();
        }
    }

}
