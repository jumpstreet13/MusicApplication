package com.smedialink.abakarmagomedov.musicapplication.domain.usecase

import com.smedialink.abakarmagomedov.musicapplication.domain.gateway.PlayerGateway
import io.reactivex.Completable
import javax.inject.Inject

/**
 * Created by abakarmagomedov on 13/02/2018 at project MusicApplication.
 */
class PlayerUseCase @Inject constructor(private val playerGateway: PlayerGateway) {

    fun loadFfmpeg(): Completable {
        return playerGateway.loadFFMpegBinary()
    }
}