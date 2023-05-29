package com.example.parcialtp3.fragments

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.parcialtp3.R
import com.example.parcialtp3.adapters.CarListAdapter
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
      //  var carImage: Drawable? = ContextCompat.getDrawable(requireContext(), R.mipmap.carmaserati)
        //var carImage = R.drawable.carmaserati

        carsList.add(Car("Maserati","Alguno","Automatico","2000","Electrico","SUV",R.drawable.carmaserati))
        carsList.add(Car("Mercedes","Algo","Automatico","2000","Electrico","SUV",R.drawable.carmercedes))
        carsList.add(Car("TOGG","Ninguno","Automatico","2000","Electrico","SUV",R.drawable.cartogg))
        carsList.add(Car("Ferrari","Cualquiera","Automatico","2000","Electrico","SUV",R.drawable.ferrari))
        carsList.add(Car("Random","Cualquiera","Automatico","2000","Electrico","SUV",R.drawable.caralgo))

        /*carsList.add(Car("Mercedes","Algo","Automatico","2000","Electrico","SUV"))
        carsList.add(Car("TOGG","Ninguno","Automatico","2000","Electrico","SUV"))
        carsList.add(Car("Random","Cualquiera","Automatico","2000","Electrico","SUV")) */

       /* for(i in 1 .. 10){
            carsList.add(Car("Toyota","Caca","Automatico","2000","Electrico","SUV"))

        } */

        val rec_cars = vista.findViewById<RecyclerView>(R.id.rec_cars)
        rec_cars.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        // Add item decoration to create space between items

        val spacingInPixels = resources.getDimensionPixelSize(R.dimen.spacing_between_items)
        rec_cars.addItemDecoration(SpacesItemDecoration(spacingInPixels))
       // rec_cars.setHasFixedSize(true)
      //  var linearLayoutManager = LinearLayoutManager(context)


        rec_cars.adapter = CarListAdapter(carsList)
        return vista


}
}