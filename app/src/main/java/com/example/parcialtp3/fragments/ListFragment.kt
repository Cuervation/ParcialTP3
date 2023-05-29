package com.example.parcialtp3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.parcialtp3.R
import com.example.parcialtp3.adapters.MakeListAdapter
import com.example.parcialtp3.entities.Car
import com.example.parcialtp3.entities.SpacesItemDecoration


class ListFragment : Fragment() {

    lateinit var vista: View
    var carsList : MutableList<Car> = ArrayList<Car>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        vista = inflater.inflate(R.layout.fragment_list, container, false)

        for(i in 1 .. 10){
            carsList.add(Car("Toyota","Caca","Automatico","2000","Electrico","SUV"))
        }

        val rec_cars = vista.findViewById<RecyclerView>(R.id.rec_cars)
        rec_cars.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        // Add item decoration to create space between items

        val spacingInPixels = resources.getDimensionPixelSize(R.dimen.spacing_between_items)
        rec_cars.addItemDecoration(SpacesItemDecoration(spacingInPixels))
       // rec_cars.setHasFixedSize(true)
      //  var linearLayoutManager = LinearLayoutManager(context)


        rec_cars.adapter = MakeListAdapter(carsList)
        return vista


}
}