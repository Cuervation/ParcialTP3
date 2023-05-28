package com.example.parcialtp3.entities

class Car(
    marca: String?,
    modelo: String?,
    tipoDeCambio: String?,
    year: String?,
    combustible: String?,
    clase: String?
) {

    var marca: String = ""
    var modelo: String =""
    var tipoDeCambio: String = ""
    var year: String = ""
    var combustible: String = ""
    var clase: String = ""

    init {
        this.marca = marca!!
        this.modelo = modelo!!
        this.tipoDeCambio = tipoDeCambio!!
        this.year = year!!
        this.combustible = combustible!!
        this.clase = clase!!
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