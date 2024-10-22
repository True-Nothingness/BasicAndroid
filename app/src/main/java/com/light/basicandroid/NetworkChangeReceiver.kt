package com.light.basicandroid

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.widget.Toast

class NetworkChangeReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val networkManager : ConnectivityManager = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = networkManager.activeNetwork
        if (activeNetwork != null) {
            Toast.makeText(context, "Connected to the internet", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Disconnected from the internet", Toast.LENGTH_SHORT).show()
        }
    }
}