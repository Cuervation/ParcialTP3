package com.example.parcialtp3.fragments

import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.parcialtp3.R
import com.example.parcialtp3.tituloSpannableString

class SettingsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onStart() {
        super.onStart()
        var textView = requireActivity().findViewById<TextView>(R.id.titleToolbar)
        val spannableString = SpannableString("Configuración")
        val textSpanIzquierda = ForegroundColorSpan(Color.BLACK)
        spannableString.setSpan(textSpanIzquierda, 0, spannableString.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        textView.text = spannableString
    }

    override fun onStop() {
        super.onStop()
        var textView = requireActivity().findViewById<TextView>(R.id.titleToolbar)
        textView.text = "PremierRentCar"
        tituloSpannableString(textView)
    }
}