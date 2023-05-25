package com.example.parcialtp3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavView : BottomNavigationView
    private lateinit var navHostFragment : NavHostFragment

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment

        val navController = navHostFragment.navController

        bottomNavView = findViewById(R.id.bottom_bar)


        NavigationUI.setupWithNavController(bottomNavView, navController)



        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.nav_view)


        setupDrawerLayout(navController)

    }

    private fun setupDrawerLayout(navController: NavController) {

        // Vinculo la navegación del drawer con la del graph
        navigationView.setupWithNavController(navController)

        // Configuro la appbar para que muestre el icono del drawer y actualice el titulo
        //NO ANDA!!!!!!!!!!!|
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)

        // Listener para cuando se realiza la navegacion
        navController.addOnDestinationChangedListener { _, _, _ ->
            // Aca le digo que quiero que mi icono izquierdo de la appbar sea el del drawer
            supportActionBar?.setHomeAsUpIndicator(R.drawable.hamburger)
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