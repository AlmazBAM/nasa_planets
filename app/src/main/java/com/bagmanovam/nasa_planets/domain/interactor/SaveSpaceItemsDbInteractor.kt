package com.bagmanovam.nasa_planets.domain.interactor

import com.bagmanovam.nasa_planets.domain.model.SpaceItem
import com.bagmanovam.nasa_planets.domain.repository.SpaceItemsDbRepository
import com.bagmanovam.nasa_planets.domain.useCase.GetSpaceItemsDbUseCase
import com.bagmanovam.nasa_planets.domain.useCase.SaveSpaceItemsDbUseCase
import kotlinx.coroutines.flow.Flow

class SaveSpaceItemsDbInteractor(private val repository: SpaceItemsDbRepository) : SaveSpaceItemsDbUseCase {
    override suspend fun invoke(items: List<SpaceItem>) {
        repository.saveAllSpaceItems(items)
    }
}