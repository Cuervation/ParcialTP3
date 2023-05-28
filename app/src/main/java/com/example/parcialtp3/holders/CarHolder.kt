package com.example.parcialtp3.holders

import android.view.View
import android.widget.TextView
//import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.parcialtp3.R

class CarHolder( v: View) : RecyclerView.ViewHolder(v) {
    private var view : View
    init {
        this.view = v
    }

    fun setMarca(marca: String){

        val txt = view.findViewById<TextView>(R.id.txtItemViewMarca)
        txt.text = marca
    }

   // fun getContainer(): CardView {
     //   return this.view.findViewById<CardView>(R.id.frameLayout)
    //}
}
