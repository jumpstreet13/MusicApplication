package com.smedialink.abakarmagomedov.musicapplication.domain.usecase

import com.smedialink.abakarmagomedov.musicapplication.domain.gateway.ConvertGateway
import io.reactivex.Completable
import javax.inject.Inject

/**
 * Created by abakarmagomedov on 13/02/2018 at project MusicApplication.
 */
class PlayerUseCase @Inject constructor(private val convertGateway: ConvertGateway) {

    fun loadFfmpeg(): Completable {
        return convertGateway.loadFFMpegBinary()
    }

    fun execFfmpeg(commands: Array<String>): Completable {
        return convertGateway.execFFmpegBinary(commands)
    }
}