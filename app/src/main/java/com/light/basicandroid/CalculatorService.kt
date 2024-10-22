package com.light.basicandroid

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder

class CalculatorService: Service() {
    private val binder = CalculatorBinder()
    inner class CalculatorBinder: Binder() {
        fun getService(): CalculatorService = this@CalculatorService
    }
    override fun onBind(intent: Intent?): IBinder? {
        return binder
    }
    fun add(a: Float, b: Float): Float {
        return a + b
    }
}