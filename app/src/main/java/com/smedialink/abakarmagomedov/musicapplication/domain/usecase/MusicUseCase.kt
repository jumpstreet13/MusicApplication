package com.smedialink.abakarmagomedov.musicapplication.domain.usecase

import com.smedialink.abakarmagomedov.musicapplication.domain.gateway.MusicGateway
import io.reactivex.Completable
import javax.inject.Inject

/**
 * Created by abakarmagomedov on 21/02/2018 at project MusicApplication.
 */
class MusicUseCase @Inject constructor(val musicGateway: MusicGateway, val musicUseCase: MusicUseCase) {

    public fun playMusic(file: String): Completable {
        return musicGateway.playFile(file)
    }

}