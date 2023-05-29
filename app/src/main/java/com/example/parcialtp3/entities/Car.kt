package com.example.parcialtp3.entities
import android.graphics.drawable.Drawable
class Car(
    marca: String?,
    modelo: String?,
    tipoDeCambio: String?,
    year: String?,
    combustible: String?,
    clase: String?,
    image: Int?,
    cantAsientos: String?
) {

    var image: Int
    var marca: String
    var modelo: String
    var tipoDeCambio: String
    var year: String
    var combustible: String
    var clase: String
    var cantAsientos: String

    init {
        this.marca = marca!!
        this.modelo = modelo!!
        this.tipoDeCambio = tipoDeCambio!!
        this.year = year!!
        this.combustible = combustible!!
        this.clase = clase!!
        this.image = image!!
        this.cantAsientos = cantAsientos!!
    }

  /*  constructor(marca: String?, modelo: String?, tipoDeCambio: String?, year: String?, combustible: String?, clase: String?){

        this.marca = marca!!
        this.modelo = modelo!!
        this.tipoDeCambio = tipoDeCambio!!
        this.year = year!!
        this.combustible = combustible!!
        this.clase = clase!!
    } */

    }