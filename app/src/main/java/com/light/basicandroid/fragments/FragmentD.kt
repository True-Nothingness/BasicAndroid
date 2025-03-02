package com.light.basicandroid.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.light.basicandroid.R


class FragmentD : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_d, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("FragmentD","onCreate")
    }
    override fun onStart() {
        super.onStart()
        Log.d("FragmentD","onStart")
    }
    override fun onResume() {
        super.onResume()
        Log.d("FragmentD","onResume")
    }
    override fun onPause() {
        super.onPause()
        Log.d("FragmentD","onPause")
    }
    override fun onStop() {
        super.onStop()
        Log.d("FragmentD","onStop")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("FragmentD","onDestroy")
    }
    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("FragmentD","onDestroyView")
    }
    override fun onDetach() {
        super.onDetach()
        Log.d("FragmentD","onDetach")
    }
}