package com.example.parcialtp3.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.parcialtp3.R
import com.example.parcialtp3.model.viewmodel.LoginViewModel
import com.example.parcialtp3.tituloSpannableString

class LoginFragment : Fragment() {
    lateinit var vista:View
    lateinit var titulo_login: TextView
    lateinit var text_usuario: TextView
    lateinit var text_password: TextView
    private lateinit var viewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_login, container, false)

        vista.findViewById<Button>(R.id.btnIngresar).setOnClickListener {
            val action = LoginFragmentDirections.actionLoginFragmentToMainActivity()
            this.findNavController().navigate(action)
            activity?.finish()
        }

        text_password = vista.findViewById(R.id.txtPassword)
        text_usuario = vista.findViewById(R.id.txtUsuario)

        titulo_login = vista.findViewById<TextView>(R.id.tituloLogin)
        tituloSpannableString(titulo_login)
        return vista

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(requireActivity())[LoginViewModel::class.java]

        viewModel.getUsuario()?.observe(viewLifecycleOwner, Observer<String?>() { result ->
            text_usuario.text = result.toString()
        })

        viewModel.getPassword()?.observe(viewLifecycleOwner, Observer<String>() { result ->
            text_password.text = result.toString()
        })
    }

}