package com.example.parcialtp3

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavView : BottomNavigationView
    private lateinit var navHostFragment : NavHostFragment
    private lateinit var appBarConfiguration : AppBarConfiguration

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView

    private lateinit var toolbar: Toolbar

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
        toolbar.setupWithNavController(navHostFragment.navController)


        setupDrawerLayout()
        tituloSpannableString(tituloToolbar)
    }

    private fun setupDrawerLayout() {
        appBarConfiguration = AppBarConfiguration.Builder(navHostFragment.navController.graph)
            .setOpenableLayout(drawerLayout)
            .build()

        // Vinculo la navegación del drawer con la del graph
//        navigationView.setupWithNavController(navHostFragment.navController)

        NavigationUI.setupWithNavController(navigationView, navHostFragment.navController)
        NavigationUI.setupWithNavController(toolbar, navHostFragment.navController, appBarConfiguration)




        // Listener para cuando se realiza la navegacion
        navHostFragment.navController.addOnDestinationChangedListener { _, destination, _ ->
            // Aca le digo que quiero que mi icono izquierdo de la appbar sea el del drawer
            //supportActionBar?.setHomeAsUpIndicator(R.drawable.hamburger)
            if (destination.id == R.id.autos || destination.id == R.id.buscar || destination.id == R.id.perfil) {
                toolbar.setNavigationIcon(R.drawable.atras)
            } else if(destination.id == R.id.home){
                toolbar.setNavigationIcon(R.drawable.hamburger_icon)
            }
        }

    }


    // Habilita la navegación desde la appbar con el drawer. Deja
    //    override fun onSupportNavigateUp(): Boolean {
    //        return NavigationUI.navigateUp(navHostFragment.navController, drawerLayout)
    //    }

    // Forzar el drawer a que se abra siempre
    override fun onSupportNavigateUp(): Boolean {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        return false
    }

}