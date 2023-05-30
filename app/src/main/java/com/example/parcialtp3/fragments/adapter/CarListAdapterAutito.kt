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
        holder.setModelo(car.model!!)
        holder.setLogo(R.drawable.bmw1)
        holder.setTipoCambio(car.drive!!)
        holder.setTipoCombustible(car.fuel_type!!)
        holder.setYear(car.year.toString())
        holder.setCylinder(car.cylinders.toString())
       // holder.setLogo(car.image)

      //  holder.setModelo(car.modelo)
      // holder.setOrden[position]

    }
}