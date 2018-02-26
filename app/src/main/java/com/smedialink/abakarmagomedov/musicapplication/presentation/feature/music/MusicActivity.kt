package com.smedialink.abakarmagomedov.musicapplication.presentation.feature.music

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.LayoutRes
import com.smedialink.abakarmagomedov.musicapplication.R
import com.smedialink.abakarmagomedov.musicapplication.presentation.base.BaseActivity

class MusicActivity : BaseActivity<MusicPresenter, MusicView>(), MusicView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music)
    }

    override fun viewCreated() {

    }

    @LayoutRes
    override fun layoutRes() = R.layout.activity_music

}
