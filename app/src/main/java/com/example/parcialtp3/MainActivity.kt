package com.example.parcialtp3

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.parcialtp3.model.viewmodel.LoginViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var navController: NavController
    lateinit var toolbar: Toolbar
    lateinit var drawer_layout: DrawerLayout
    lateinit var navigation_view: NavigationView
    private lateinit var nombreToolbar: TextView
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_zeta)

        //Drawer Layout
        drawer_layout = findViewById(R.id.drawer_layout)

        //NavView
        navigation_view = findViewById(R.id.navigation_view)

        //Bottom Bar
        val bottom_navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        navController = findNavController(R.id.host_fragment)
        bottom_navigation.setupWithNavController(navController)

        //Toolbar
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        //Nav Up
        appBarConfiguration = AppBarConfiguration(navController.graph, drawer_layout)
        NavigationUI.setupActionBarWithNavController(this, navController, drawer_layout)

        //Drawer Navigation
        NavigationUI.setupWithNavController(navigation_view, navController)

        nombreToolbar = navigation_view.getHeaderView(0).findViewById(R.id.txtNombreToolbar)

        toolbar.setupWithNavController(navController)
        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        val sharedPreference =  getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        var user = sharedPreference.getString("username","No Registrado").toString()
        nombreToolbar.text =user
        viewModel.changeUsuario(user)
        setupDrawerLayout()
        val tituloToolbar = findViewById<TextView>(R.id.titleToolbar)
        tituloSpannableString(tituloToolbar)

    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, appBarConfiguration)
    }

    private fun setupDrawerLayout() {
        appBarConfiguration = AppBarConfiguration.Builder(navController.graph)
            .setOpenableLayout(drawer_layout)
            .build()

        NavigationUI.setupWithNavController(navigation_view, navController)
        NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.autos || destination.id == R.id.buscar || destination.id == R.id.perfil) {
                toolbar.setNavigationIcon(R.drawable.atras)
            } else if(destination.id == R.id.home){
                toolbar.setNavigationIcon(R.drawable.hamburger_icon)
            }
        }

    }
}