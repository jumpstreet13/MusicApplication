package com.smedialink.abakarmagomedov.musicapplication.presentation.base

interface BasePresenter<V : BaseView> {

    var view: V?

    fun onViewAttached(view: V)

    fun onStart()

    fun onStop()

    fun onViewDetached()

}