package com.smedialink.abakarmagomedov.musicapplication.presentation.feature.player

import android.Manifest
import android.annotation.SuppressLint
import android.os.Bundle
import android.support.annotation.LayoutRes

import com.smedialink.abakarmagomedov.musicapplication.R
import com.smedialink.abakarmagomedov.musicapplication.presentation.base.BaseActivity
import java.io.File
import android.provider.MediaStore
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import com.smedialink.abakarmagomedov.musicapplication.presentation.feature.player.adapter.MusicAdapter
import kotlinx.android.synthetic.main.activity_player.*
import permissions.dispatcher.NeedsPermission
import permissions.dispatcher.RuntimePermissions
import com.github.hiteshsondhi88.libffmpeg.FFmpeg
import com.smedialink.abakarmagomedov.musicapplication.presentation.feature.player.view.impl.getPlayListWithPermissionCheck
import com.smedialink.abakarmagomedov.musicapplication.presentation.feature.player.view.impl.onRequestPermissionsResult
import javax.inject.Inject
import java.util.*


@RuntimePermissions
class PlayerActivity : BaseActivity<PlayerPresenter, PlayerView>(), PlayerView, MusicAdapter.MusicItemClickListener {

    @Inject
    lateinit var ffmpeg: FFmpeg
    private val MEDIA_PATH = MediaStore.Audio.Media.getContentUri("external").toString()
    private val dir = android.os.Environment.getExternalStorageDirectory()
    private val filepath = ArrayList<String>()
    private lateinit var adapter: MusicAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MediaPath", MEDIA_PATH)
        adapter = MusicAdapter(this)
        musicList.adapter = adapter
        musicList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        music.setOnClickListener({
            getPlayListWithPermissionCheck(dir)
            adapter.setNewData(filepath)
        })
    }

    @SuppressLint("NeedOnRequestPermissionsResult")
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        //super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        // NOTE: delegate the permission handling to generated method
        onRequestPermissionsResult(requestCode, grantResults)
    }

    @LayoutRes
    override fun layoutRes() = R.layout.activity_player

    override fun musicItemClicked(musicPath: String) {
        Toast.makeText(this, musicPath, Toast.LENGTH_SHORT).show()
    }

    override fun loadFfmpegSuccessfully() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun viewCreated() {

    }

    @NeedsPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
    fun getPlayList(dir: File) {
        val listFile = dir.listFiles()
        if (listFile.isEmpty()) return
        for (i in 0 until listFile.size) {
            if (listFile[i].isDirectory) {
                getPlayList(listFile[i])
            } else {
                if (listFile[i].absoluteFile.toString().endsWith(".mp3"))
                    filepath.add(listFile[i].absolutePath)

            }
        }
    }
}









