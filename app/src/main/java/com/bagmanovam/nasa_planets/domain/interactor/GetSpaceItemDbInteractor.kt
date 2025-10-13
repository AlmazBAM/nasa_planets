package com.bagmanovam.nasa_planets.domain.interactor

import com.bagmanovam.nasa_planets.domain.model.SpaceItem
import com.bagmanovam.nasa_planets.domain.repository.SpaceItemsDbRepository
import com.bagmanovam.nasa_planets.domain.useCase.GetSpaceItemDbUseCase
import kotlinx.coroutines.flow.Flow

class GetSpaceItemDbInteractor(
    private val repository: SpaceItemsDbRepository,
) : GetSpaceItemDbUseCase {
    override suspend fun invoke(itemId: Int): SpaceItem {
        return repository.getSpaceItem(itemId)
    }
}