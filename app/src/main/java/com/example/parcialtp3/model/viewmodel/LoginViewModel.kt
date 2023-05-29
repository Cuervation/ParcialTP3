package com.example.parcialtp3.model.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    private var usuario: MutableLiveData<String>? = null
    private var password: MutableLiveData<String>? = null

    fun changeUsuario(nuevoUsuario: String){
        usuario?.postValue(nuevoUsuario)
    }
    fun changePassword(nuevaPassword: String) {
        password?.postValue(nuevaPassword)
    }

    fun getUsuario(): MutableLiveData<String>? {
        if (usuario == null) {
            usuario = MutableLiveData()
        }
        return usuario
    }
    fun getPassword(): MutableLiveData<String>? {
        if (password == null) {
            password = MutableLiveData()
        }
        return password
    }
}