package com.light.basicandroid

import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activity1 : AppCompatActivity() {
    private lateinit var networkChangeReceiver: NetworkChangeReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val act1TV1: TextView = findViewById(R.id.act1TV1)
        val act1TV2: TextView = findViewById(R.id.act1TV2)
        val act1TV3: TextView = findViewById(R.id.act1TV3)
        val act1TV4: TextView = findViewById(R.id.act1TV4)
        val act1TV5: TextView = findViewById(R.id.act1TV5)
        Log.d("Activity1", "onCreate")
        startService(Intent(this, BGMusicService::class.java))
        val bundle = Bundle()
        bundle.putString("act1","From Activity1")
        val intent = Intent(this, Activity2::class.java)
        intent.putExtras(bundle)
        act1TV1.setOnClickListener {
            stopService(Intent(this, BGMusicService::class.java))
            startActivity(intent)
        }
        act1TV2.setOnClickListener {
            stopService(Intent(this, BGMusicService::class.java))
            startActivity(Intent(this, CalculatorActivity::class.java))
        }
        act1TV3.setOnClickListener {
            stopService(Intent(this, BGMusicService::class.java))
            startActivity(Intent(this, FragmentActivity::class.java))
        }
        act1TV4.setOnClickListener {
            stopService(Intent(this, BGMusicService::class.java))
            startActivity(Intent(this, ListViewActivity::class.java))
        }
        act1TV5.setOnClickListener {
            stopService(Intent(this, BGMusicService::class.java))
            startActivity(Intent(this, FragmentActivity2::class.java))
        }
        networkChangeReceiver = NetworkChangeReceiver()

        val intentFilter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        registerReceiver(networkChangeReceiver, intentFilter)
    }
    override fun onStart() {
        super.onStart()
        Log.d("Activity1", "onStart")
    }
    override fun onPause() {
        super.onPause()
        Log.d("Activity1", "onPause")
    }
    override fun onResume() {
        super.onResume()
        Log.d("Activity1", "onResume")
    }
    override fun onStop() {
        super.onStop()
        Log.d("Activity1", "onStop")
    }
    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(networkChangeReceiver)
        Log.d("Activity1", "onDestroy")
    }
    override fun onRestart() {
        super.onRestart()
        startService(Intent(this, BGMusicService::class.java))
        Log.d("Activity1", "onRestart")
    }
}