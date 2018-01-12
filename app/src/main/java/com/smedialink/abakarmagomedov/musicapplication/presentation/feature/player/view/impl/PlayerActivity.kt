package com.smedialink.abakarmagomedov.musicapplication.presentation.feature.player.view.impl

import android.os.Bundle
import android.support.annotation.LayoutRes

import com.smedialink.abakarmagomedov.musicapplication.R
import com.smedialink.abakarmagomedov.musicapplication.presentation.base.BaseActivity
import com.smedialink.abakarmagomedov.musicapplication.presentation.feature.player.view.PlayerView
import com.smedialink.abakarmagomedov.musicapplication.presentation.feature.player.presenter.PlayerPresenter
import java.io.File
import android.provider.MediaStore


/*
Add this:
@ContributesAndroidInjector(modules = arrayOf(PlayerViewModule::class))
fun providePlayerActivityFactory(): PlayerActivity
to builder module
*/
class PlayerActivity : BaseActivity<PlayerPresenter, PlayerView>(), PlayerView {

    private val MEDIA_PATH = MediaStore.Audio.Media.getContentUri("external").toString()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getPlayList()
    }

    @LayoutRes
    override fun layoutRes() = R.layout.activity_player

    override fun viewCreated() {

    }

    fun getPlayList(): List<String>? {
        val home = File(MEDIA_PATH)

        for (file in home.listFiles()) {
            System.out.println(file.name)
        }
        return null;
    }

}
