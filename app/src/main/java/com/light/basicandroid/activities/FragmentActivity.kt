package com.light.basicandroid.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.light.basicandroid.fragments.FragmentA
import com.light.basicandroid.R

class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fragment)
        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, FragmentA())
            .commit()
    }
}