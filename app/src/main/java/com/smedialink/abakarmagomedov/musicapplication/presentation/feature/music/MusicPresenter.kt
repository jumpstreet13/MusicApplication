package com.smedialink.abakarmagomedov.musicapplication.presentation.feature.music

import com.smedialink.abakarmagomedov.musicapplication.domain.usecase.MusicUseCase
import com.smedialink.abakarmagomedov.musicapplication.domain.usecase.PlayerUseCase
import com.smedialink.abakarmagomedov.musicapplication.presentation.base.BasePresenterImpl
import com.smedialink.abakarmagomedov.musicapplication.presentation.feature.player.PlayerView
import javax.inject.Inject

/**
 * Created by abakarmagomedov on 21/02/2018 at project MusicApplication.
 */
class MusicPresenter @Inject constructor(private val musicUseCase: MusicUseCase) : BasePresenterImpl<MusicView>() {

}