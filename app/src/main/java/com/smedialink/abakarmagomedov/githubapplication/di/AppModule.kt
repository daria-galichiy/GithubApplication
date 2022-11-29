package com.smedialink.abakarmagomedov.githubapplication.di

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by abakarmagomedov on 15/05/17.
 */
@Singleton
@Module
class AppModule(private val mContext: Context) {
    @Singleton
    @Provides
    fun provideContext(): Context {
        return mContext
    }
}
