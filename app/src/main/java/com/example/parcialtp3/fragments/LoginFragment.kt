package com.example.parcialtp3.fragments

//import android.R
import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.BackgroundColorSpan
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
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

        //var btnIngresar =  vista.findViewById<TextView>(R.id.btnIngresar)

        vista.findViewById<Button>(R.id.btnIngresar).setOnClickListener {
            val action = LoginFragmentDirections.actionLoginFragmentToMainActivity()
            this.findNavController().navigate(action)

        }


        titulo_login = vista.findViewById<TextView>(R.id.tituloLogin)

        tituloSpannableString(titulo_login)
        return vista

    }
    private fun tituloSpannableString(titulo:TextView) {
        //VERRRRR
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

}