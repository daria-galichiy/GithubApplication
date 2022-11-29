package com.smedialink.abakarmagomedov.githubapplication

import android.app.Application
import android.content.Context

/**
 * Created by abakarmagomedov on 15/05/17.
 */
class App : Application() {
    lateinit var componentsHolder: ComponentsHolder

    override fun onCreate() {
        super.onCreate()
        componentsHolder = ComponentsHolder(this)
        componentsHolder.init()
    }

    companion object {
        @JvmStatic
        fun getApp(context: Context): App {
            return context.applicationContext as App
        }
    }
}
