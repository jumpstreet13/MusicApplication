package com.smedialink.abakarmagomedov.musicapplication.presentation.base

import android.content.Context
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View

import dagger.android.support.AndroidSupportInjection

import javax.inject.Inject

abstract class BaseFragment<P : BasePresenter<V>, V : BaseView> : Fragment() {

    @Inject lateinit var presenter: P

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?) =
            inflater?.inflate(layoutRes(), container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.onViewAttached(this as V)
        presenter.onStart()
    }

    override fun onDestroyView() {
        presenter.onStop()
        presenter.onViewDetached()

        super.onDestroyView()
    }

    @LayoutRes
    protected abstract fun layoutRes(): Int

}
