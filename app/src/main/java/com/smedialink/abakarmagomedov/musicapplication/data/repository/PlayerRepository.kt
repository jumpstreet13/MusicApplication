package com.smedialink.abakarmagomedov.musicapplication.data.repository

import android.util.Log
import android.widget.Toast
import com.github.hiteshsondhi88.libffmpeg.ExecuteBinaryResponseHandler
import com.github.hiteshsondhi88.libffmpeg.FFmpeg
import com.github.hiteshsondhi88.libffmpeg.LoadBinaryResponseHandler
import com.github.hiteshsondhi88.libffmpeg.exceptions.FFmpegCommandAlreadyRunningException
import com.github.hiteshsondhi88.libffmpeg.exceptions.FFmpegNotSupportedException
import com.smedialink.abakarmagomedov.musicapplication.domain.gateway.PlayerGateway
import io.reactivex.Completable
import io.reactivex.functions.Action
import javax.inject.Inject

/**
 * Created by abakarmagomedov on 13/02/2018 at project MusicApplication.
 */
class PlayerRepository @Inject constructor(private val ffmpeg: FFmpeg) : PlayerGateway {

    override fun playFile(path: String): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadFFMpegBinary(): Completable {
        return Completable.fromAction({
            try {
                ffmpeg?.loadBinary(object : LoadBinaryResponseHandler() {
                    override fun onFailure() {
                        Log.d("Player", "Can not load ffmpeg")
                    }
                })
            } catch (e: FFmpegNotSupportedException) {
                Log.d("Player", "unsupported ffmpeg")
            }
        })
    }

    override fun execFFmpegBinary(command: Array<String>): Completable {
        try {
            ffmpeg?.execute(command, object : ExecuteBinaryResponseHandler() {
                override fun onFailure(s: String?) {
                    Log.d("Player", "FAILED with output : " + s)
                }

                override fun onSuccess(s: String?) {
                    Log.d("Player", "SUCCESS with output : " + s)
                }

                override fun onProgress(s: String?) {
                    Log.d("Player", "Started command : ffmpeg " + command)
                }

                override fun onStart() {
                    Log.d("Player", "Started command : ffmpeg " + command)
                }

                override fun onFinish() {
                    Log.d("Player", "Finished command : ffmpeg " + command)
                }
            })
        } catch (e: FFmpegCommandAlreadyRunningException) {
            Log.d("Player", e.printStackTrace().toString())
        }
        return Completable.complete()
    }
}