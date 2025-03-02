package com.light.basicandroid.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.light.basicandroid.R


class FragmentC : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_c, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("FragmentC","onCreate")
    }
    override fun onStart() {
        super.onStart()
        Log.d("FragmentC","onStart")
    }
    override fun onResume() {
        super.onResume()
        Log.d("FragmentC","onResume")
    }
    override fun onPause() {
        super.onPause()
        Log.d("FragmentC","onPause")
    }
    override fun onStop() {
        super.onStop()
        Log.d("FragmentC","onStop")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("FragmentC","onDestroy")
    }
    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("FragmentC","onDestroyView")
    }
    override fun onDetach() {
        super.onDetach()
        Log.d("FragmentC","onDetach")
    }

}