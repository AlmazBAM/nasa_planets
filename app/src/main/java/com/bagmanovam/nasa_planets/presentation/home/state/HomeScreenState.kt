package com.bagmanovam.nasa_planets.presentation.home.state

import androidx.compose.runtime.Immutable
import com.bagmanovam.nasa_planets.domain.model.SpaceItem

@Immutable
data class HomeScreenState(
    val isLoading: Boolean = false,
    val query: String = "",
    val spaceItems: List<SpaceItem> = emptyList(),
)