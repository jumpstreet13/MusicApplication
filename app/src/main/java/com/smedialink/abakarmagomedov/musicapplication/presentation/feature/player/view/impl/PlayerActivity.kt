package com.smedialink.abakarmagomedov.musicapplication.presentation.feature.player.view.impl

import android.os.Bundle
import android.support.annotation.LayoutRes

import com.smedialink.abakarmagomedov.musicapplication.R
import com.smedialink.abakarmagomedov.musicapplication.presentation.base.BaseActivity
import com.smedialink.abakarmagomedov.musicapplication.presentation.feature.player.view.PlayerView
import com.smedialink.abakarmagomedov.musicapplication.presentation.feature.player.presenter.PlayerPresenter

/*
Add this:
@ContributesAndroidInjector(modules = arrayOf(PlayerViewModule::class))
fun providePlayerActivityFactory(): PlayerActivity
to builder module
*/
class PlayerActivity : BaseActivity<PlayerPresenter, PlayerView>(), PlayerView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @LayoutRes
    override fun layoutRes() = R.layout.activity_player

    override fun viewCreated() {

    }

}
