package com.light.basicandroid

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activity2 : AppCompatActivity() {
    private lateinit var networkChangeReceiver: NetworkChangeReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val act2TV: TextView = findViewById(R.id.act2TV)
        val fgmBtn: ImageButton = findViewById(R.id.fgmBtn)
        Log.d("Activity2", "onCreate")
        val bundle = intent.extras
        val s:String? = bundle!!.getString("act1")
        Log.d("Message", s.toString())
        act2TV.setOnClickListener {
            startActivity(Intent(this, CalculatorActivity::class.java))
        }
        fgmBtn.setOnClickListener {
            startService(Intent(this, FGMusicService::class.java))
        }
        networkChangeReceiver = NetworkChangeReceiver()

        val intentFilter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        registerReceiver(networkChangeReceiver, intentFilter)
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
        Log.d("Activity2", "onDestroy");
    }
    override fun onRestart() {
        super.onRestart()
        Log.d("Activity2", "onRestart");
    }
}