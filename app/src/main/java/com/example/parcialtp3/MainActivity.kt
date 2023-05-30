package com.example.parcialtp3

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.parcialtp3.model.viewmodel.LoginViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView



class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavView : BottomNavigationView
    private lateinit var navHostFragment : NavHostFragment
    private lateinit var appBarConfiguration : AppBarConfiguration

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var nombreToolbar: TextView

    private lateinit var toolbar: Toolbar
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tituloToolbar = findViewById<TextView>(R.id.titleToolbar)

        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment

        val navController = navHostFragment.navController
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)


        bottomNavView = findViewById(R.id.bottom_bar)

        toolbar.setBackgroundColor(resources.getColor(R.color.white))

        NavigationUI.setupWithNavController(bottomNavView, navController)


        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.nav_view)
        nombreToolbar = navigationView.getHeaderView(0).findViewById(R.id.txtNombreToolbar)


        toolbar.setupWithNavController(navHostFragment.navController)
        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        val sharedPreference =  getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        var user = sharedPreference.getString("username","No Registrado").toString()
        nombreToolbar.text =user
        viewModel.changeUsuario(user)
        setupDrawerLayout()
        tituloSpannableString(tituloToolbar)
    }

    private fun setupDrawerLayout() {
        appBarConfiguration = AppBarConfiguration.Builder(navHostFragment.navController.graph)
            .setOpenableLayout(drawerLayout)
            .build()

        NavigationUI.setupWithNavController(navigationView, navHostFragment.navController)
        NavigationUI.setupWithNavController(toolbar, navHostFragment.navController, appBarConfiguration)

        navHostFragment.navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.autos || destination.id == R.id.buscar || destination.id == R.id.perfil) {
                toolbar.setNavigationIcon(R.drawable.atras)
            } else if(destination.id == R.id.home){
                toolbar.setNavigationIcon(R.drawable.hamburger_icon)
            }
        }

    }


    override fun onSupportNavigateUp(): Boolean {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        return false
    }

}