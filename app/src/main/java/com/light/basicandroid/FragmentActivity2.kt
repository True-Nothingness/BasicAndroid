package com.light.basicandroid

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FragmentActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fragment2)
        // Add Fragment A to the first container
        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer1, FragmentA())
            .commit()

        // Add Fragment B to the second container
        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer2, FragmentB())
            .commit()
    }
}