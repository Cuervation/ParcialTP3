package com.example.parcialtp3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.parcialtp3.R
import com.example.parcialtp3.adapters.CarListAdapterAutito
import com.example.parcialtp3.entities.Car
import com.example.parcialtp3.entities.SpacesItemDecoration
import com.example.parcialtp3.entities.SpacesItemDecorationAutito


class CarListFragment : Fragment() {

    lateinit var vista: View
    var autosList : MutableList<Car> = ArrayList<Car>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        vista = inflater.inflate(R.layout.fragment_list_autos, container, false)
      //  var carImage: Drawable? = ContextCompat.getDrawable(requireContext(), R.mipmap.carmaserati)
        //var carImage = R.drawable.carmaserati

        autosList.add(Car("Maserati","Alguno","Automatico","2000","Electrico","SUV",R.drawable.carmaserati,"Two seater"))
        autosList.add(Car("Mercedes","Algo","Automatico","2000","Electrico","SUV",R.drawable.carmercedes,"Two seater"))
        autosList.add(Car("TOGG","Ninguno","Automatico","2000","Electrico","SUV",R.drawable.cartogg,"Two seater"))
        autosList.add(Car("Ferrari","Cualquiera","Automatico","2000","Electrico","SUV",R.drawable.ferrari,"Two seater"))
        autosList.add(Car("Random","Cualquiera","Automatico","2000","Electrico","SUV",R.drawable.caralgo,"Two seater"))

        /*carsList.add(Car("Mercedes","Algo","Automatico","2000","Electrico","SUV"))
        carsList.add(Car("TOGG","Ninguno","Automatico","2000","Electrico","SUV"))
        carsList.add(Car("Random","Cualquiera","Automatico","2000","Electrico","SUV")) */

       /* for(i in 1 .. 10){
            carsList.add(Car("Toyota","Caca","Automatico","2000","Electrico","SUV"))

        } */

        val autitounico = vista.findViewById<RecyclerView>(R.id.autitosunicos)
        autitounico.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        // Add item decoration to create space between items

        val spacingInPixels = resources.getDimensionPixelSize(R.dimen.spacing_between_items_autos)
        autitounico.addItemDecoration(SpacesItemDecorationAutito(spacingInPixels))
       // rec_cars.setHasFixedSize(true)
      //  var linearLayoutManager = LinearLayoutManager(context)


       autitounico.adapter = CarListAdapterAutito(autosList)
        return vista


}
}