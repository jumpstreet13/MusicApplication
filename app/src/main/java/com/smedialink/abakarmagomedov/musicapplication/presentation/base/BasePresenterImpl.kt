package com.smedialink.abakarmagomedov.musicapplication.presentation.base

import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenterImpl<V : BaseView> : BasePresenter<V> {

    override var view: V? = null
    protected lateinit var compositeDisposable: CompositeDisposable;

    override fun onViewAttached(view: V) {
        this.view = view
        compositeDisposable = CompositeDisposable();
    }

    override fun onStart() {

    }

    override fun onStop() {

    }

    override fun onViewDetached() {
        view = null
        compositeDisposable.dispose()
    }

}
