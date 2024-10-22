package com.light.basicandroid

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.util.Log

class BGMusicService : Service() {
    private lateinit var mediaPlayer: MediaPlayer
    override fun onBind(intent: Intent?): IBinder? {
        Log.d("BGMusicService", "onBind")
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        stopService(Intent(this, FGMusicService::class.java))
        mediaPlayer = MediaPlayer.create(this, R.raw.seisyun_complex)
        mediaPlayer.isLooping = true
        mediaPlayer.start()
        return START_STICKY
    }
    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.stop()
        mediaPlayer.release()
    }
}