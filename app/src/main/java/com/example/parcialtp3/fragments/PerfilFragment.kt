package com.example.parcialtp3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.parcialtp3.R
import com.example.parcialtp3.model.viewmodel.LoginViewModel

class PerfilFragment : Fragment() {
    lateinit var view: View
    private lateinit var viewModel: LoginViewModel
    private lateinit var texto_usuario: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(requireActivity())[LoginViewModel::class.java]
        view = inflater.inflate(R.layout.fragment_perfil, container, false)
        texto_usuario = view.findViewById(R.id.txtNameProfile)
        texto_usuario.text = viewModel.getUsuario().toString()


        // Inflate the layout for this fragment
        return view
    }
}