package com.smedialink.abakarmagomedov.githubapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by abakarmagomedov on 15/05/17.
 */

public class BaseActivity extends AppCompatActivity {

    protected @NonNull ProgressDialog mProgressDialog;

    protected void start(Class<?> cls, String login) {
        Intent intent = new Intent(this, cls);
        intent.putExtra(Constants.LOGIN, login);
        startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mProgressDialog = new ProgressDialog(this, R.style.ProgressBarStyle);
        mProgressDialog.setCancelable(false);
    }

    public void showProgress() {
        if (!mProgressDialog.isShowing()) {
            mProgressDialog.show();
        }

    }

    public void hideProgress() {
        if (mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }


    protected AlertDialog getErrorDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton(R.string.Ok, (dialog, which) -> dialog.dismiss());
        builder.setMessage(R.string.no_internet);
        return builder.create();
    }

}
