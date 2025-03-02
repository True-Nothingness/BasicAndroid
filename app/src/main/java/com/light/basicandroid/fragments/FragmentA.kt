package com.light.basicandroid.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.light.basicandroid.R

class FragmentA : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("FragmentA", "onViewCreated")

        val button: Button = view.findViewById(R.id.changeFragmentBtn)
        button.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, FragmentB())
                .addToBackStack(null)
                .commit()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("FragmentA", "onCreate")
    }
    override fun onStart() {
        super.onStart()
        Log.d("FragmentA", "onStart")
    }
    override fun onResume() {
        super.onResume()
        Log.d("FragmentA", "onResume")
    }
    override fun onPause() {
        super.onPause()
        Log.d("FragmentA", "onPause")
    }
    override fun onStop() {
        super.onStop()
        Log.d("FragmentA", "onStop")
    }
    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("FragmentA", "onDestroyView")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("FragmentA", "onDestroy")
    }
    override fun onDetach() {
        super.onDetach()
        Log.d("FragmentA", "onDetach")
    }
}
