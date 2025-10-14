package com.bagmanovam.nasa_planets.presentation.home

sealed interface HomeEvent {

    data class OnQueryChange(val query: String): HomeEvent
    data object OnRefresh: HomeEvent
}