package com.bagmanovam.nasa_planets.presentation.description

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bagmanovam.nasa_planets.domain.useCase.GetSpaceItemDbUseCase
import com.bagmanovam.nasa_planets.presentation.description.state.DescriptionState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DescriptionViewModel(
    private val getSpaceItemDbUseCase: GetSpaceItemDbUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow<DescriptionState>(DescriptionState())
    val uiState = _uiState
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            DescriptionState()
        )

    fun getSpaceItemById(itemId: Int) {
        viewModelScope.launch {
            val item = getSpaceItemDbUseCase(itemId)
            _uiState.update { state ->
                state.copy(
                    title = item.title,
                    description = item.explanation,
                    imageUrl = item.url
                )
            }
        }
    }
}