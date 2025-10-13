package com.bagmanovam.nasa_planets.presentation.home.state

import androidx.compose.runtime.Immutable
import com.bagmanovam.nasa_planets.domain.model.SpaceObject

@Immutable
data class HomeScreenState(
    val isLoading: Boolean = false,
    val query: String = "",
    val spaceObjects: List<SpaceObject> = emptyList(),
)