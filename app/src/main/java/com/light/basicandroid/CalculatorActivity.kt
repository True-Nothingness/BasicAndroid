package com.light.basicandroid

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CalculatorActivity : AppCompatActivity() {
    private var calculatorService: CalculatorService? = null
    private var isBound = false
    private val connection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            val binder = service as CalculatorService.CalculatorBinder
            calculatorService = binder.getService()
            Log.d("CalculatorActivity", "Service connected")
            isBound = true
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            Log.d("CalculatorActivity", "Service disconnected")
            isBound = false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculator)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val numberET1: EditText = findViewById(R.id.numberET1)
        val numberET2: EditText = findViewById(R.id.numberET2)
        val addBtn: ImageButton = findViewById(R.id.addBtn)
        val resultTV: TextView = findViewById(R.id.resultTV)
        addBtn.setOnClickListener {
            if (isBound) {
                val a = numberET1.text.toString().toFloatOrNull()
                val b = numberET2.text.toString().toFloatOrNull()

                if (a != null && b != null) {
                    val result = calculatorService?.add(a, b)
                    resultTV.text = result.toString()
                } else {
                    resultTV.text = getString(R.string.invalid)
                }
            } else {
                resultTV.text = getString(R.string.unbound)
            }
        }
    }
    override fun onStart() {
        super.onStart()
        val intent = Intent(this, CalculatorService::class.java)
        bindService(intent, connection, Context.BIND_AUTO_CREATE)
    }
    override fun onDestroy() {
        super.onDestroy()
        if (isBound) {
            unbindService(connection)
            isBound = false
        }
    }
}