package com.smedialink.abakarmagomedov.musicapplication.domain.gateway

import io.reactivex.Completable

/**
 * Created by abakarmagomedov on 21/02/2018 at project MusicApplication.
 */
interface MusicGateway {
    fun playFile(file: String): Completable
}