package com.example.task_ui.common

import android.app.Application
import com.example.task_ui.data.di.component.AppComponent
import com.example.task_ui.data.di.component.DaggerAppComponent
import com.example.task_ui.data.network.Api
import javax.inject.Inject

/**
 * I'm daggering the AppComponent to make a singleton from some classes like Api and other classes
 *
 */


class App @Inject constructor() : Application(){

    @Inject
    lateinit var api: Api

    private lateinit var component: AppComponent
    override fun onCreate() {
        super.onCreate()
        instance = this

        component = DaggerAppComponent.builder().build()
        component.injectApp(app = this)
    }


    fun getComponent(): AppComponent = component

    companion object {
        lateinit var instance: App
            private set
    }

}