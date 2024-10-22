package com.light.basicandroid

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat

class FGMusicService : Service() {
    private lateinit var mediaPlayer: MediaPlayer
    override fun onBind(intent: Intent?): IBinder? {
        Log.d("FGMusicService", "onBind")
        return null
    }
    override fun onCreate() {
        super.onCreate()
        Log.d("FGMusicService", "onCreate")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "FGMusicChannel",
                "Music Playback",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(channel)
        }
        mediaPlayer = MediaPlayer.create(this, R.raw.seisyun_complex)
    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (intent?.action == "STOP") {
            stopSelf()
        } else {
            stopService(Intent(this, BGMusicService::class.java))
            mediaPlayer.isLooping = true
            mediaPlayer.start()

            val notificationIntent = Intent(this, Activity1::class.java)
            val pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                PendingIntent.FLAG_MUTABLE)
            val stopIntent = Intent(this, FGMusicService::class.java).apply {
                action = "STOP"
            }
            val stopPendingIntent = PendingIntent.getService(this, 1, stopIntent,
                PendingIntent.FLAG_MUTABLE)
            val notification = NotificationCompat.Builder(this, "FGMusicChannel")
                .setContentTitle("Music Service")
                .setContentText("Playing Seisyun Complex")
                .setSmallIcon(R.drawable.ic_music_note)
                .setContentIntent(pendingIntent)
                .addAction(R.drawable.ic_stop, "Stop", stopPendingIntent)
                .setOngoing(true)
                .build()

            startForeground(1, notification)
        }
        return START_STICKY
    }
    override fun onDestroy(){
        super.onDestroy()
        mediaPlayer.stop()
        mediaPlayer.release()
    }
}