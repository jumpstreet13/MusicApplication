package com.smedialink.abakarmagomedov.musicapplication.domain.usecase.base

import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.observers.DisposableObserver

abstract class ObservableUseCase<in PARAMS, RESULT>(
        private val workerScheduler: Scheduler,
        private val mainThreadScheduler: Scheduler)
    : DisposableUseCase() {

    fun execute(observer: DisposableObserver<RESULT>, parameters: PARAMS) {
        addDisposable(build(parameters)
                .subscribeOn(workerScheduler)
                .observeOn(mainThreadScheduler)
                .subscribeWith(observer)
        )
    }

    protected abstract fun build(parameters: PARAMS): Observable<RESULT>

}