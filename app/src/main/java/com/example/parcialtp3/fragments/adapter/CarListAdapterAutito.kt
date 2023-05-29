package com.example.parcialtp3.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.parcialtp3.R
import com.example.parcialtp3.entities.Car
import com.example.parcialtp3.holders.CarHolder
import com.example.parcialtp3.holders.CarHolderAuto

class CarListAdapterAutito(
    private val autosList: MutableList<Car>


) : RecyclerView.Adapter<CarHolderAuto>() {


    override fun getItemCount() = autosList.size



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarHolderAuto {
         val view =  LayoutInflater.from(parent.context).inflate(R.layout.fragment_auto_view, parent, false)
        return CarHolderAuto(view)
    }

    override fun onBindViewHolder(holder: CarHolderAuto, position: Int) {
        val car = autosList[position]
        holder.setModelo(car.modelo)
        holder.setLogo(car.image)
        holder.setTipoCambio(car.tipoDeCambio)
        holder.setTipoCombustible(car.combustible)
        holder.setYear(car.year)
        holder.setCantAsientos(car.cantAsientos)
       // holder.setLogo(car.image)

      //  holder.setModelo(car.modelo)
      // holder.setOrden[position]

    }
}