package com.smedialink.abakarmagomedov.musicapplication.domain.usecase.base

import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.observers.DisposableSingleObserver

abstract class SingleUseCase<in PARAMS, RESULT>(
        private val workerScheduler: Scheduler,
        private val mainThreadScheduler: Scheduler)
    : DisposableUseCase() {

    fun execute(observer: DisposableSingleObserver<RESULT>, parameters: PARAMS) {
        addDisposable(build(parameters)
                .subscribeOn(workerScheduler)
                .observeOn(mainThreadScheduler)
                .subscribeWith(observer)
        )
    }

    protected abstract fun build(parameters: PARAMS): Single<RESULT>
}