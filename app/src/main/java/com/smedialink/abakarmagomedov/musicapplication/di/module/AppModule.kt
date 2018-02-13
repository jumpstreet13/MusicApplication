package com.smedialink.abakarmagomedov.musicapplication.di.module

import android.content.Context

import com.smedialink.abakarmagomedov.musicapplication.App
import com.smedialink.abakarmagomedov.musicapplication.di.scope.PerApplication

import dagger.Module
import dagger.Provides
import com.github.hiteshsondhi88.libffmpeg.FFmpeg
import javax.inject.Singleton


@Module
class AppModule {

    @PerApplication
    @Provides
    fun provideContext(application: App): Context = application

    @PerApplication
    @Provides
    fun provideFFmpeg(application: App): FFmpeg {
        return FFmpeg.getInstance(application)
    }
}
