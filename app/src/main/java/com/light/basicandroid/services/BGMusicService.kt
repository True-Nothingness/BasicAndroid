package com.light.basicandroid.services

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.util.Log
import com.light.basicandroid.R

class BGMusicService : Service() {
    private lateinit var mediaPlayer: MediaPlayer
    override fun onBind(intent: Intent?): IBinder? {
        Log.d("BGMusicService", "onBind")
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        mediaPlayer = MediaPlayer.create(this, R.raw.seisyun_complex)
        mediaPlayer.isLooping = true
        mediaPlayer.start()
        Log.d("BGMusicService", "Service starting - closing app")
        val closeAppIntent = Intent("com.light.basicandroid.CLOSE_APP")
        sendBroadcast(closeAppIntent)
        return START_STICKY
    }
    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.stop()
        mediaPlayer.release()
    }
}