package com.bagmanovam.nasa_planets

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.bagmanovam.nasa_planets.presentation.home.HomeScreen
import com.bagmanovam.nasa_planets.presentation.home.HomeScreenViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun NasaNavHost(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = Home
    ) {
        composable<Home> {
            val homeScreenViewModel = koinViewModel<HomeScreenViewModel>(viewModelStoreOwner = it)
            val uiState by homeScreenViewModel.uiState.collectAsStateWithLifecycle()
            HomeScreen(
                uiState = uiState,
                onHomeAction = homeScreenViewModel::onAction,
                onItemClick = {

                }
            )
        }

        composable<Description> {
            val itemId = it.toRoute<Description>().itemId

        }
    }
}