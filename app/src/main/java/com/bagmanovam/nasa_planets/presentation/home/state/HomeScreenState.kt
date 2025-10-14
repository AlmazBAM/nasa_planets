package com.bagmanovam.nasa_planets.presentation.home.state

import androidx.compose.runtime.Immutable
import com.bagmanovam.nasa_planets.core.domain.NetworkError
import com.bagmanovam.nasa_planets.domain.model.SpaceItem

@Immutable
data class HomeScreenState(
    val isLoading: Boolean = false,
    val isSwipedToUpdate: Boolean = false,
    val errorMessage: NetworkError? = null,
    val query: String = "",
    val spaceItems: List<SpaceItem> = emptyList(),
)