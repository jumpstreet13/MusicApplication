package com.smedialink.abakarmagomedov.musicapplication.presentation.feature.player

import android.support.annotation.UiThread
import com.smedialink.abakarmagomedov.musicapplication.presentation.base.BaseView

@UiThread
interface PlayerView : BaseView {
    fun loadFfmpegSuccessfully()
}