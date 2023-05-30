package com.example.parcialtp3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.parcialtp3.R
import com.google.android.material.card.MaterialCardView

class HomeFragment : Fragment() {

    lateinit var vista: View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        vista = inflater.inflate(R.layout.fragment_home, container, false)
        vista.findViewById<MaterialCardView>(R.id.rectanguloamarillo).setOnClickListener {
            val action = HomeFragmentDirections.actionHomeToAutos2()
            this.findNavController().navigate(action)

        }

        vista.findViewById<MaterialCardView>(R.id.rectanguloazul).setOnClickListener {
            val action = HomeFragmentDirections.actionHomeToAutos2()
            this.findNavController().navigate(action)

        }
        vista.findViewById<MaterialCardView>(R.id.rectanguloceleste).setOnClickListener {
            val action = HomeFragmentDirections.actionHomeToAutos2()
            this.findNavController().navigate(action)

        }
        return vista
    }


}