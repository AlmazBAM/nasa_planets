package com.bagmanovam.nasa_planets.presentation.description.state

import androidx.compose.runtime.Immutable

@Immutable
data class DescriptionState(
    val title: String = "",
    val description: String = "",
    val imageUrl: String = "",
)