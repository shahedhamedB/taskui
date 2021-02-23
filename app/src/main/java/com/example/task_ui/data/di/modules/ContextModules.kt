package com.example.task_ui.data.di.modules

import android.content.Context
import com.example.task_ui.common.App
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class ContextModules {
    @Singleton
    @Provides
    fun providesContext(): Context {
        return App.instance.applicationContext
    }
}