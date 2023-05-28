package com.example.parcialtp3

import android.graphics.Color
import android.text.SpannableString
import android.text.Spanned
import android.text.style.BackgroundColorSpan
import android.text.style.ForegroundColorSpan
import android.widget.TextView

fun tituloSpannableString(titulo: TextView) {
    val texto = titulo.text.toString()
    val spannableString = SpannableString(texto)

    // Calcula la posición de la mitad del texto
    val mitad = texto.length / 2

    // Crea un BackgroundColorSpan para el color de la mitad izquierda
    val colorSpanIzquierda = BackgroundColorSpan(Color.parseColor("#3330E5"))

    spannableString.setSpan(colorSpanIzquierda, 0, mitad, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

    // Crea un BackgroundColorSpan para el color de la mitad derecha
    val colorSpanDerecha = BackgroundColorSpan(Color.parseColor("#FFCC00"))
    spannableString.setSpan(
        colorSpanDerecha,
        mitad,
        texto.length,
        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
    )
    // Crea un ForegroundColorSpan para el color de texto de la mitad izquierda
    val textSpanIzquierda = ForegroundColorSpan(Color.WHITE)
    spannableString.setSpan(textSpanIzquierda, 0, mitad, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
    // Crea un ForegroundColorSpan para el color de texto de la mitad derecha
    val textSpanDerecha = ForegroundColorSpan(Color.BLACK)
    spannableString.setSpan(
        textSpanDerecha,
        mitad,
        texto.length,
        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
    )

    // Establece el SpannableString en el TextView
    titulo.text = spannableString

}