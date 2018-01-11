package com.smedialink.abakarmagomedov.musicapplication.domain.usecase.base

import io.reactivex.Completable
import io.reactivex.Scheduler
import io.reactivex.observers.DisposableCompletableObserver

abstract class CompletableUseCase<in PARAMS>(
        private val workerScheduler: Scheduler,
        private val mainThreadScheduler: Scheduler)
    : DisposableUseCase() {

    fun execute(observer: DisposableCompletableObserver, parameters: PARAMS) {
        addDisposable(build(parameters)
                .subscribeOn(workerScheduler)
                .observeOn(mainThreadScheduler)
                .subscribeWith(observer)
        )
    }

    protected abstract fun build(parameters: PARAMS): Completable
}
