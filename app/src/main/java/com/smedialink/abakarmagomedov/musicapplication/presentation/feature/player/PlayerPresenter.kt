package com.smedialink.abakarmagomedov.musicapplication.presentation.feature.player

import com.smedialink.abakarmagomedov.musicapplication.domain.usecase.PlayerUseCase
import com.smedialink.abakarmagomedov.musicapplication.presentation.base.BasePresenterImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Action
import io.reactivex.schedulers.Schedulers

import javax.inject.Inject

class PlayerPresenter @Inject constructor(private val playerUseCase: PlayerUseCase) : BasePresenterImpl<PlayerView>() {

    fun loadFfmpeg() {
        compositeDisposable.add(playerUseCase.loadFfmpeg()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ view?.loadFfmpegSuccessfully() }))
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
    }

}