package com.smedialink.abakarmagomedov.musicapplication.presentation.feature.player.adapter

import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.smedialink.abakarmagomedov.musicapplication.R

/**
 * Created by abakarmagomedov on 13/02/2018 at project MusicApplication.
 */
class MusicAdapter(private val listener: MusicItemClickListener) : BaseQuickAdapter<String, BaseViewHolder>(R.layout.music_item) {

    public interface MusicItemClickListener {
        fun musicItemClicked(musicPath: String)
    }

    override fun convert(helper: BaseViewHolder?, item: String?) {
        helper?.setText(R.id.song_name, item)
        helper?.itemView?.setOnClickListener({
            item?.let { it1 -> listener.musicItemClicked(it1) }
        })
    }
}

