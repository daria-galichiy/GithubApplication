package com.smedialink.abakarmagomedov.githubapplication.di

import javax.inject.Singleton
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.OkHttpClient
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.smedialink.abakarmagomedov.githubapplication.data.net.GithubApi
import com.smedialink.abakarmagomedov.githubapplication.data.net.Links
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.schedulers.Schedulers

/**
 * Created by abakarmagomedov on 15/05/17.
 */
@Singleton
@Module
class NetModule {
    @Singleton
    @Provides
    fun provideOkhttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(interceptor)
        return httpClient.build()
    }

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
            .create()
    }

    @Singleton
    @Provides
    fun providesHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return logging
    }

    @Singleton
    @Provides
    fun provideYandexApi(client: OkHttpClient): GithubApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(provideGson()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .client(client)
            .baseUrl(Links.BASE_URL)
            .build().create(GithubApi::class.java)
    }
}
