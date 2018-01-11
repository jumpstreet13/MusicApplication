package com.smedialink.abakarmagomedov.musicapplication.presentation.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.annotation.LayoutRes

import dagger.android.AndroidInjection

import javax.inject.Inject

abstract class BaseActivity<P : BasePresenter<V>, V : BaseView> : AppCompatActivity() {

    @Inject
    lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(layoutRes())
        viewCreated()

        presenter.onViewAttached(this as V)
        presenter.onStart()
    }

    override fun onDestroy() {
        presenter.onStop()
        presenter.onViewDetached()

        super.onDestroy()
    }

    @LayoutRes
    protected abstract fun layoutRes(): Int

    protected abstract fun viewCreated()
}
