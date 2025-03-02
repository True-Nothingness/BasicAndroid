package com.light.basicandroid.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.light.basicandroid.R

class FragmentB : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_b, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("FragmentB", "onViewCreated")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("FragmentB", "onCreate")
    }
    override fun onStart() {
        super.onStart()
        Log.d("FragmentB", "onStart")
    }
    override fun onResume() {
        super.onResume()
        Log.d("FragmentB", "onResume")
    }
    override fun onPause() {
        super.onPause()
        Log.d("FragmentB", "onPause")
    }
    override fun onStop() {
        super.onStop()
        Log.d("FragmentB", "onStop")
    }
    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("FragmentB", "onDestroyView")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("FragmentB", "onDestroy")
    }
    override fun onDetach() {
        super.onDetach()
        Log.d("FragmentB", "onDetach")
    }
}