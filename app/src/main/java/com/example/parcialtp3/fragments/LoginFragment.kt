package com.example.parcialtp3.fragments

import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.parcialtp3.R


class LoginFragment : Fragment() {
    lateinit var vista:View
    lateinit var titulo_login: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        vista = inflater.inflate(R.layout.fragment_login, container, false)
        titulo_login = vista.findViewById<TextView>(R.id.tituloLogin)
        val spannableString = SpannableString(titulo_login.getText())
        val textLength = spannableString.length
        val splitPosition = textLength / 2
        val verdeSpan = ForegroundColorSpan(Color.parseColor("#000000"))
        val naranjaSpan = ForegroundColorSpan(Color.parseColor("#00FFFF"))
        spannableString.setSpan(verdeSpan, 0, splitPosition, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(naranjaSpan, splitPosition, textLength, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        return vista

    }


}