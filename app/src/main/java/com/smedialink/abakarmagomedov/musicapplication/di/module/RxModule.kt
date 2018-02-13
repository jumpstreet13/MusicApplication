package com.smedialink.abakarmagomedov.musicapplication.di.module

import com.smedialink.abakarmagomedov.musicapplication.di.qualifier.ComputationScheduler;
import com.smedialink.abakarmagomedov.musicapplication.di.qualifier.MainScheduler;
import com.smedialink.abakarmagomedov.musicapplication.di.qualifier.IoScheduler;
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.annotations.NonNull
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

@Module
class RxModule {

    @Provides
    @NonNull
    fun provideCompositeDisposable() = CompositeDisposable()

    @Provides
    @IoScheduler
    fun provideSchedulerIO(): Scheduler = Schedulers.io()

    @Provides
    @ComputationScheduler
    fun provideSchedulerComputation(): Scheduler = Schedulers.computation()

    @Provides
    @MainScheduler
    fun provideSchedulerMainThread(): Scheduler = AndroidSchedulers.mainThread()

}
