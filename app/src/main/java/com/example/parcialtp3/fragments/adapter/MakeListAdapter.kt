package com.example.parcialtp3.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.parcialtp3.R
import com.example.parcialtp3.entities.Car
import com.example.parcialtp3.holders.CarHolder

class MakeListAdapter(
    private val carsList: MutableList<Car>


) : RecyclerView.Adapter<CarHolder>() {


    override fun getItemCount() = carsList.size



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarHolder {
         val view =  LayoutInflater.from(parent.context).inflate(R.layout.fragment_item_view, parent, false)
        return CarHolder(view)
    }

    override fun onBindViewHolder(holder: CarHolder, position: Int) {
        val car = carsList[position]
        holder.setMarca(car.make!!)
        holder.setLogo(R.drawable.ferrari)
       // holder.setLogo(car.image)

      //  holder.setModelo(car.modelo)
      // holder.setOrden[position]

    }
}