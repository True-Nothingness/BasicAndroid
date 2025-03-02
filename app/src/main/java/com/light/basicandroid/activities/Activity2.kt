package com.light.basicandroid.activities

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.light.basicandroid.services.FGMusicService
import com.light.basicandroid.NetworkChangeReceiver
import com.light.basicandroid.R
import com.light.basicandroid.services.BGMusicService

class Activity2 : AppCompatActivity() {
    private lateinit var networkChangeReceiver: NetworkChangeReceiver
    private val closeAppReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            finishAffinity()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val bgmBtn: Button = findViewById(R.id.bgmBtn)
        val fgmBtn: Button = findViewById(R.id.fgmBtn)
        Log.d("Activity2", "onCreate")
        val bundle = intent.extras
        val s:String? = bundle!!.getString("act1")
        Log.d("Message", s.toString())
        bgmBtn.setOnClickListener {
            stopService(Intent(this, FGMusicService::class.java))
            startService(Intent(this, BGMusicService::class.java))
        }
        fgmBtn.setOnClickListener {
            stopService(Intent(this, BGMusicService::class.java))
            startService(Intent(this, FGMusicService::class.java))
        }
        networkChangeReceiver = NetworkChangeReceiver()

        val intentFilter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        registerReceiver(networkChangeReceiver, intentFilter)
        val filter = IntentFilter("com.light.basicandroid.CLOSE_APP")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) { // API 34+
            registerReceiver(closeAppReceiver, filter, Context.RECEIVER_NOT_EXPORTED)
        } else {
            @Suppress("UnspecifiedRegisterReceiverFlag")
            registerReceiver(closeAppReceiver, filter) // Use older method for API 24-33
        }
    }
    override fun onStart() {
        super.onStart()
        Log.d("Activity2", "onStart");
    }
    override fun onPause() {
        super.onPause()
        Log.d("Activity2", "onPause");
    }
    override fun onResume() {
        super.onResume()
        Log.d("Activity2", "onResume");
    }
    override fun onStop() {
        super.onStop()
        Log.d("Activity2", "onStop");
    }
    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(networkChangeReceiver)
        unregisterReceiver(closeAppReceiver)
        Log.d("Activity2", "onDestroy");
    }
    override fun onRestart() {
        super.onRestart()
        Log.d("Activity2", "onRestart");
    }
}