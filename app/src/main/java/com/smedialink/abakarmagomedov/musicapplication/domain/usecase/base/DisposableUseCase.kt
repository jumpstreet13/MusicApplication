package com.smedialink.abakarmagomedov.musicapplication.domain.usecase.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class DisposableUseCase {

    private val disposable = CompositeDisposable()

    protected fun dispose() {
        if (!disposable.isDisposed) {
            disposable.dispose()
        }
    }

    protected fun addDisposable(disposable: Disposable) {
        this.disposable.add(disposable)
    }

}