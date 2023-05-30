package com.example.parcialtp3.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.parcialtp3.R
import com.example.parcialtp3.entities.Marca
import com.example.parcialtp3.holders.CarHolder

class MakeListAdapter(
    private val marcasList: MutableList<Marca>


) : RecyclerView.Adapter<CarHolder>() {


    override fun getItemCount() = marcasList.size



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarHolder {
         val view =  LayoutInflater.from(parent.context).inflate(R.layout.fragment_item_view, parent, false)
        return CarHolder(view)
    }

    override fun onBindViewHolder(holder: CarHolder, position: Int) {
        val marca = marcasList[position]
        holder.setMarca(marca.marca)
        holder.setLogo(marca.logo)
       // holder.setLogo(car.image)

      //  holder.setModelo(car.modelo)
      // holder.setOrden[position]

    }
}