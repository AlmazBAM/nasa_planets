package com.bagmanovam.nasa_planets

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.bagmanovam.nasa_planets.presentation.description.DescriptionScreen
import com.bagmanovam.nasa_planets.presentation.description.DescriptionViewModel
import com.bagmanovam.nasa_planets.presentation.home.HomeScreen
import com.bagmanovam.nasa_planets.presentation.home.HomeScreenViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun NasaSpaceNavHost(
    navHostController: NavHostController,
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
                onItemClick = { itemId ->
                    navHostController.navigate(Description(itemId))
                }
            )
        }

        composable<Description> {
            val viewModel = koinViewModel<DescriptionViewModel>(viewModelStoreOwner = it)
            val itemId = it.toRoute<Description>().itemId
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val isMainScreen = it.destination.hasRoute(Home::class)

            LaunchedEffect(itemId) {
                viewModel.getSpaceItemById(itemId)
            }

            DescriptionScreen(
                uiState = uiState,
                isMainScreen = isMainScreen,
                onBackClick = {
                    navHostController.popBackStack()
                }
            )
        }
    }
}