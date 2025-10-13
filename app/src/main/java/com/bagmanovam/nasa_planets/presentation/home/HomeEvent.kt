package com.bagmanovam.nasa_planets.presentation.home

import com.bagmanovam.nasa_planets.Home

sealed interface HomeEvent {

    data class QueryChange(val query: String): HomeEvent

}