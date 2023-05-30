package com.example.parcialtp3.fragments

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.parcialtp3.R
import com.example.parcialtp3.adapters.CarListAdapterAutito
import com.example.parcialtp3.entities.Car
import com.example.parcialtp3.entities.SpacesItemDecorationAutito
import com.example.parcialtp3.model.CarsResponse
import com.example.parcialtp3.services.CarsServiceApiBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


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

        GetCars()

//        val autitounico = vista.findViewById<RecyclerView>(R.id.autitosunicos)
//        autitounico.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
//
//        val spacingInPixels = resources.getDimensionPixelSize(R.dimen.spacing_between_items_autos)
//        autitounico.addItemDecoration(SpacesItemDecorationAutito(spacingInPixels))
//
//        Log.i("autos", autosList.toString())
//        autitounico.adapter = CarListAdapterAutito(autosList)
        return vista
    }

    fun GetCars(){
        val service = CarsServiceApiBuilder.create()
        Log.i("service", service.toString())
        try{
            service.getCars("bmw").enqueue(object : Callback<MutableList<Car>?> {
                override fun onResponse(call: Call<MutableList<Car>?>, response: Response<MutableList<Car>?>) {
                    if (response.isSuccessful) {
                        val response = response.body()
                        if (response != null) {
                            setCarList(response)
                        }
                    }
                }

                override fun onFailure(call: Call<MutableList<Car>?>, t: Throwable) {
                    Log.e("Example", t.stackTraceToString())
                }
            })
        }catch(e: Exception) {
            Log.e(ContentValues.TAG, "The exception caught while executing the process. (error1)")
            e.printStackTrace();
        }

    }

    private fun setCarList(carResponse: MutableList<Car>){
        autosList = carResponse

        val autitounico = vista.findViewById<RecyclerView>(R.id.autitosunicos)
        autitounico.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)

        val spacingInPixels = resources.getDimensionPixelSize(R.dimen.spacing_between_items_autos)
        autitounico.addItemDecoration(SpacesItemDecorationAutito(spacingInPixels))

        Log.i("autos", autosList.toString())
        autitounico.adapter = CarListAdapterAutito(autosList)
    }
}