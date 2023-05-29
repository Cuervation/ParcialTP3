package com.example.parcialtp3.holders

import android.graphics.drawable.Drawable
import android.media.Image
import android.view.View
import android.widget.ImageView
import android.widget.TextView
//import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.parcialtp3.R

class CarHolder( v: View) : RecyclerView.ViewHolder(v) {
    var view: View

    init {
        this.view = v
    }

    fun setMarca(marca: String) {

        val eleccion = view.findViewById<TextView>(R.id.txtItemViewMarca)
        eleccion.text = marca
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
}


