package com.smedialink.abakarmagomedov.musicapplication.di

import com.smedialink.abakarmagomedov.musicapplication.App
import com.smedialink.abakarmagomedov.musicapplication.di.scope.PerApplication

import com.smedialink.abakarmagomedov.musicapplication.di.module.AppModule
import com.smedialink.abakarmagomedov.musicapplication.di.module.NetworkModule
import com.smedialink.abakarmagomedov.musicapplication.di.module.RxModule
import com.smedialink.abakarmagomedov.musicapplication.di.module.AppBuilderModule

import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.AndroidInjector
import dagger.Component;

@PerApplication
@Component(modules = [(AppModule::class), (RxModule::class), (NetworkModule::class), (AppBuilderModule::class), (AndroidSupportInjectionModule::class)])
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()

}