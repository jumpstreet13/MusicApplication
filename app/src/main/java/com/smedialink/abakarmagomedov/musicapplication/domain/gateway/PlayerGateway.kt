package com.smedialink.abakarmagomedov.musicapplication.domain.gateway

import io.reactivex.Completable

/**
 * Created by abakarmagomedov on 13/02/2018 at project MusicApplication.
 */
interface PlayerGateway {
    fun playFile(path: String): Completable
    fun loadFFMpegBinary(): Completable
    fun execFFmpegBinary(command: Array<String>): Completable
}