package com.smedialink.abakarmagomedov.githubapplication.di;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.smedialink.abakarmagomedov.githubapplication.data.net.GithubApi;
import com.smedialink.abakarmagomedov.githubapplication.data.net.Links;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by abakarmagomedov on 15/05/17.
 */

@Singleton
@Module
public class NetModule {

    @Singleton
    @NonNull
    @Provides
    OkHttpClient provideOkhttpClient(HttpLoggingInterceptor interceptor) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(interceptor);
        return httpClient.build();
    }

    @Singleton
    @NonNull
    @Provides
    Gson provideGson() {
        return new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .create();
    }


    @Singleton
    @NonNull
    @Provides
    HttpLoggingInterceptor providesHttpLoggingInterceptor() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        return logging;
    }



    @Singleton
    @Provides
    GithubApi provideYandexApi(OkHttpClient client){
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(provideGson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .client(client)
                .baseUrl(Links.BASE_URL)
                .build().create(GithubApi.class);

    }

}
