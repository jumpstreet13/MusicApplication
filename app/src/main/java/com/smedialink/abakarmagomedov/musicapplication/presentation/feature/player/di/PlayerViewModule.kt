package com.smedialink.abakarmagomedov.musicapplication.presentation.feature.player.di

import com.smedialink.abakarmagomedov.musicapplication.data.repository.ConvertRepository
import com.smedialink.abakarmagomedov.musicapplication.domain.gateway.ConvertGateway
import dagger.Binds
import dagger.Module

@Module
interface PlayerViewModule {

    @Binds
    fun providePlayerGateway(playerRepository: ConvertRepository): ConvertGateway
}
