package com.bagmanovam.nasa_planets.presentation.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bagmanovam.nasa_planets.core.domain.onError
import com.bagmanovam.nasa_planets.core.domain.onSuccess
import com.bagmanovam.nasa_planets.domain.model.SpaceItem
import com.bagmanovam.nasa_planets.domain.useCase.GetSpaceItemsDbUseCase
import com.bagmanovam.nasa_planets.domain.useCase.GetSpaceItemsUseCase
import com.bagmanovam.nasa_planets.domain.useCase.SaveSpaceItemsDbUseCase
import com.bagmanovam.nasa_planets.presentation.home.state.HomeScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class HomeScreenViewModel(
    private val requestUseCase: GetSpaceItemsUseCase,
    private val saveDbUseCase: SaveSpaceItemsDbUseCase,
    private val getDbUseCase: GetSpaceItemsDbUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeScreenState())
    val uiState = _uiState
        .onStart {
            _uiState.update {
                it.copy(
                    isLoading = false
                )
            }
            requestUseCase(20)
                .onSuccess {
                    Log.e(TAG, "onSuccess: ")
                    _uiState.update { state ->
                        state.copy(
                            isLoading = true
                        )
                    }
                    saveDbUseCase(it)
                }
                .onError {
                    Log.e(TAG, "onError: ")
                    val items = getDbUseCase().first()
                    _uiState.update {
                        it.copy(
                            isLoading = true,
                            spaceItems = items
                        )
                    }
                }
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