package com.example.pam_quicklearn

import android.content.Context
import android.net.Uri
import android.util.Log
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.AssetDataSource
import com.google.android.exoplayer2.upstream.DataSource

import com.google.android.exoplayer2.util.Util


enum class SourceType{
    local_audio, local_video, http_audio, http_video
}

data class PlayerState(var window: Int = 0,
                       var position: Long = 0,
                       var whenReady: Boolean = false,
                       var source: SourceType = SourceType.local_audio,
                       var uristringAudio: String = "assets:///Hamilton.mp3",
                       var uristringVideo: String = "assets:///Hamilton-Film.mp4"
)

class PlayerHolder(val context: Context, val playerView: PlayerView, val playerState: PlayerState) {

    val player: SimpleExoPlayer
    val dataSourceFactory: DataSource.Factory
    init{
        player = ExoPlayerFactory.newSimpleInstance(context, DefaultTrackSelector()).also{
            playerView.player = it

            Log.d("Exo", "SimpleExoPlayer created")

            dataSourceFactory = object : DataSource.Factory
            {
                override fun createDataSource(): DataSource
                {
                    return AssetDataSource(context)
                }
            }
        }
    }

    fun start(){
        player.prepare(buildMediaSource(selectMediaToPlay(playerState.source)))
        //player.playWhenReady = true
        with(playerState){
            player.playWhenReady = whenReady
            player.seekTo(window, position)
        }
    }

    fun selectMediaToPlay(source: SourceType): Uri {
        return when (source) {
            SourceType.local_audio -> Uri.parse(playerState.uristringAudio)
            SourceType.local_video -> Uri.parse(playerState.uristringVideo)
            SourceType.http_audio -> Uri.parse("http://site.../file.mp3")
            SourceType.http_video -> Uri.parse("https://www.youtube.com/watch?v=WQNTsX9BAro")
            else -> Uri.parse("https://www.youtube.com/watch?v=WQNTsX9BAro")
        }
    }

    private fun buildMediaSource(uri: Uri): ExtractorMediaSource {
        val userAgent = Util.getUserAgent(context, context.packageName)
        return ExtractorMediaSource.Factory(
            dataSourceFactory
        ).createMediaSource(uri)
    }

    fun stop () {
        with(player){
            with(playerState) {
                position = currentPosition
                window = currentWindowIndex
                whenReady = playWhenReady
            }
            stop(true)
        }

        Log.d("Exo", "SimpleExoPlayer is stopped")
    }

    fun release(){
        player.release()
        Log.d("Exo", "SimpleExoPlayer is released")
    }
}