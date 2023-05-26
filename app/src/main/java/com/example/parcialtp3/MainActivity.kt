package com.example.parcialtp3

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.BackgroundColorSpan
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
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

        val tituloToolbar = findViewById<TextView>(R.id.titleToolbar)

        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment

        val navController = navHostFragment.navController

        bottomNavView = findViewById(R.id.bottom_bar)


        NavigationUI.setupWithNavController(bottomNavView, navController)



        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.nav_view)


        setupDrawerLayout(navController)
        tituloSpannableString(tituloToolbar)
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


    private fun tituloSpannableString(titulo:TextView) {
        val texto = titulo.text.toString()
        val spannableString = SpannableString(texto)

        // Calcula la posición de la mitad del texto
        val mitad = texto.length / 2

        // Crea un BackgroundColorSpan para el color de la mitad izquierda
        val colorSpanIzquierda = BackgroundColorSpan(Color.parseColor("#3330E5"))

        spannableString.setSpan(colorSpanIzquierda, 0, mitad, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        // Crea un BackgroundColorSpan para el color de la mitad derecha
        val colorSpanDerecha = BackgroundColorSpan(Color.parseColor("#FFCC00"))
        spannableString.setSpan(
            colorSpanDerecha,
            mitad,
            texto.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        // Crea un ForegroundColorSpan para el color de texto de la mitad izquierda
        val textSpanIzquierda = ForegroundColorSpan(Color.WHITE)
        spannableString.setSpan(textSpanIzquierda, 0, mitad, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        // Crea un ForegroundColorSpan para el color de texto de la mitad derecha
        val textSpanDerecha = ForegroundColorSpan(Color.BLACK)
        spannableString.setSpan(
            textSpanDerecha,
            mitad,
            texto.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        // Establece el SpannableString en el TextView
        titulo.text = spannableString

    }

}