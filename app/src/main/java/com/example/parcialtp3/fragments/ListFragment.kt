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
import com.example.parcialtp3.adapters.MakeListAdapter
import com.example.parcialtp3.entities.Marca
import com.example.parcialtp3.entities.SpacesItemDecoration


class ListFragment : Fragment() {

    lateinit var vista: View
    var listaMarcas : MutableList<Marca> = ArrayList<Marca>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        vista = inflater.inflate(R.layout.fragment_list, container, false)
        //var carImage: Drawable? = ContextCompat.getDrawable(requireContext(), R.mipmap.carmaserati)
        //var carImage = R.drawable.carmaserati

        listaMarcas.add(Marca( "Maserati", R.drawable.carmaserati))
        listaMarcas.add(Marca("Mercedes", R.drawable.carmercedes))
        listaMarcas.add(Marca("TOGG", R.drawable.cartogg))
        listaMarcas.add(Marca("Porsche", R.drawable.caralgo))
        listaMarcas.add(Marca("Ferrari", R.drawable.ferrari))

        val rec_cars = vista.findViewById<RecyclerView>(R.id.rec_cars)
        rec_cars.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        // Add item decoration to create space between items

        val spacingInPixels = resources.getDimensionPixelSize(R.dimen.spacing_between_items)
        rec_cars.addItemDecoration(SpacesItemDecoration(spacingInPixels))
       // rec_cars.setHasFixedSize(true)
      //  var linearLayoutManager = LinearLayoutManager(context)


        rec_cars.adapter = MakeListAdapter(listaMarcas)
        return vista
    }
}