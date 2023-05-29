package com.example.parcialtp3.fragments

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.parcialtp3.R
import com.example.parcialtp3.model.CarsResponse
import com.example.parcialtp3.services.CarsServiceApiBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class CarListFragment : Fragment() {

//    private lateinit var carsList : CarsResponse
        private lateinit var carText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_car_list, container, false)
        carText = view.findViewById(R.id.car_text)

        try{
            GetCars()
            Log.println(1, "", carText.text.toString())
        }catch(e: Exception) {
            Log.e(ContentValues.TAG, "The exception caught while executing the process. (error1)")
            e.printStackTrace();
        }

        return view
    }

    fun GetCars(){
        val service = CarsServiceApiBuilder.create()

        try{
            service.getCars("toyota").enqueue(object : Callback<CarsResponse> {
                override fun onResponse(call: Call<CarsResponse?>, response: Response<CarsResponse?>) {
                    if (response.isSuccessful) {
                        val cars = response.body()
                        if (cars != null) {
                            carText.text = cars.cars[0].make
                        }
                    }
                }

                override fun onFailure(call: Call<CarsResponse>, t: Throwable) {
                    Log.e("Example", t.stackTraceToString())
                }
            })
        }catch(e: Exception) {
            Log.e(ContentValues.TAG, "The exception caught while executing the process. (error1)")
            e.printStackTrace();
        }
    }
}