package com.smedialink.abakarmagomedov.musicapplication.di.module

import android.content.Context

import com.smedialink.abakarmagomedov.musicapplication.App
import com.smedialink.abakarmagomedov.musicapplication.di.scope.PerApplication

import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @PerApplication
    @Provides
    fun provideContext(application: App): Context = application

}
