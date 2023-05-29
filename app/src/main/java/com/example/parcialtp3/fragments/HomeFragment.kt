package com.example.parcialtp3.fragments

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import com.example.parcialtp3.R
import java.lang.Exception

class HomeFragment : Fragment() {

    lateinit var vista:View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        vista =  inflater.inflate(R.layout.fragment_home, container, false)

        try{
            vista.findViewById<ImageView>(R.id.rectanguloamarillo).setOnClickListener {
                val action = HomeFragmentDirections.actionHomeToCarListFragment()
                this.findNavController().navigate(action)
                activity?.finish()
            }
        }catch(e: Exception) {
            Log.e(TAG, "The exception caught while executing the process. (error1)")
            e.printStackTrace();
        }


        return vista
    }
}