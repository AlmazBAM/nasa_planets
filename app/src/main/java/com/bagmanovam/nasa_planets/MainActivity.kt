package com.bagmanovam.nasa_planets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.bagmanovam.nasa_planets.presentation.theme.Nasa_planetsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppContent()
        }
    }
}

@Composable
fun AppContent() {
    Nasa_planetsTheme {
        val navHostController = rememberNavController()
        NasaNavHost(navHostController = navHostController)
    }
}