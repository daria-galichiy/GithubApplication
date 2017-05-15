package com.smedialink.abakarmagomedov.githubapplication.di;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.SnapHelper;

import com.smedialink.abakarmagomedov.githubapplication.R;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by abakarmagomedov on 15/05/17.
 */

@Singleton
@Module
public class UtilsModule {

    @Singleton
    @Provides
    SnapHelper provideSnapHelper() {
        return new LinearSnapHelper();
    }


}
