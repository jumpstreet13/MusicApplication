package com.smedialink.abakarmagomedov.musicapplication.di.module

import com.smedialink.abakarmagomedov.musicapplication.di.scope.PerActivity
import com.smedialink.abakarmagomedov.musicapplication.presentation.feature.player.di.PlayerViewModule
import com.smedialink.abakarmagomedov.musicapplication.presentation.feature.player.view.impl.PlayerActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface AppBuilderModule {

    @PerActivity
    @ContributesAndroidInjector(modules = [(PlayerViewModule::class)])
    fun providePlayerActivityFactory(): PlayerActivity

}