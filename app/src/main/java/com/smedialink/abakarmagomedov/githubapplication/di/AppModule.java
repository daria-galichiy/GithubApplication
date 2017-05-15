package com.smedialink.abakarmagomedov.githubapplication.di;

import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by abakarmagomedov on 15/05/17.
 */

@Singleton
@Module
public class AppModule {

    private final Context mContext;

    public AppModule(Context context) {
        mContext = context;
    }

    @Singleton
    @NonNull
    @Provides
    Context provideContext() {
        return mContext;
    }


}
