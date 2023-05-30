package com.example.parcialtp3.holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
//import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.parcialtp3.R

class CarHolderAuto(v: View) : RecyclerView.ViewHolder(v) {
    var view: View

    init {
        this.view = v
    }

    fun setModelo(modelo: String) {

        val eleccion = view.findViewById<TextView>(R.id.txtItemViewModelo)
        eleccion.text = modelo
    }

    fun setLogo(image: Int) {

        val eleccion = view.findViewById<ImageView>(R.id.logo)
        eleccion.setImageResource(image)

        //eleccion.setImageResource(R.drawable.carmaserati)
        // eleccion.setImageResource(logoauto)

        // fun getContainer(): CardView {
        //   return this.view.findViewById<CardView>(R.id.frameLayout)
        //}
    }

    fun setTipoCambio(tipoCambio: String) {
        val eleccion = view.findViewById<TextView>(R.id.txtItemViewTipoCambio)
        eleccion.text = tipoCambio
    }

    fun setTipoCombustible(tipoCombustible: String) {
        val eleccion = view.findViewById<TextView>(R.id.txtItemViewTipoCombustible)
        eleccion.text = tipoCombustible
    }

    fun setYear(year: String) {
        val eleccion = view.findViewById<TextView>(R.id.txtItemViewYear)
        eleccion.text = year
    }

    fun setCylinder(cylinders: String) {
        val eleccion = view.findViewById<TextView>(R.id.txtItemViewCylinders)
        eleccion.text = cylinders
    }
}


