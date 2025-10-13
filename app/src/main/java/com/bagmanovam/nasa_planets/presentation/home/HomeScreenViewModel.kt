package com.bagmanovam.nasa_planets.presentation.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bagmanovam.nasa_planets.presentation.home.state.HomeScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn

class HomeScreenViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(HomeScreenState())
    val uiState = _uiState
        .onStart {

        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            HomeScreenState()
        )


    fun onAction(event: HomeEvent) {
        when (event) {
            is HomeEvent.QueryChange -> {
                Log.i(TAG, "query changed: ${event.query}")
            }
        }
    }

    companion object {
        private val TAG = HomeScreenViewModel::class.java.simpleName
    }
}