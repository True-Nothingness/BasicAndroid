package com.light.basicandroid.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.light.basicandroid.R
import com.light.basicandroid.fragments.FragmentC
import com.light.basicandroid.fragments.FragmentD

class FragmentActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fragment2)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer1, FragmentC())
            .commit()

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer2, FragmentD())
            .commit()
    }
}