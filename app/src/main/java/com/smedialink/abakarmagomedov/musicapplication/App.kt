package com.smedialink.abakarmagomedov.musicapplication

import com.smedialink.abakarmagomedov.musicapplication.di.DaggerAppComponent
import com.squareup.leakcanary.LeakCanary
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import io.realm.Realm

class App : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
            DaggerAppComponent.builder().create(this)

}