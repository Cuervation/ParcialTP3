package com.example.parcialtp3.fragments

import android.animation.ObjectAnimator
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.parcialtp3.R
import java.util.Timer
import java.util.TimerTask


class SplashFragment : Fragment() {
    lateinit var timer: Timer
    var progress: Int = 0
    val totalTime: Long = 5000
    val interval: Long = 100
    lateinit var vista:View
    lateinit var progressBar: ProgressBar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vista = inflater.inflate(R.layout.fragment_splash, container, false)
        progressBar = vista.findViewById<ProgressBar>(R.id.progressBar)

        return vista


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        simulateProgress()
    }

    private fun simulateProgress() {
        val animation = ObjectAnimator.ofInt(progressBar, "progress", 0, 100)
        animation.duration = 5000 // Duración de 5 segundos en milisegundos
        animation.interpolator = LinearInterpolator()
        animation.start()

        Handler().postDelayed({
            // Aquí puedes realizar la transición al LoginFragment
            navigateToLoginFragment()
        }, 5000) // Retraso de 5 segundos en milisegundos
    }


    private fun navigateToLoginFragment() {
        val action = SplashFragmentDirections.actionSplashFragmentToLoginFragment()
        this.findNavController().navigate(action)
    }

}