package com.smedialink.abakarmagomedov.githubapplication.di

import javax.inject.Singleton
import android.support.v7.widget.SnapHelper
import android.support.v7.widget.LinearSnapHelper
import dagger.Module
import dagger.Provides

/**
 * Created by abakarmagomedov on 15/05/17.
 */
@Singleton
@Module
class UtilsModule {
    @Singleton
    @Provides
    fun provideSnapHelper(): SnapHelper {
        return LinearSnapHelper()
    }
}
