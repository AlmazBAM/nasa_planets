package com.bagmanovam.nasa_planets.domain.interactor

import com.bagmanovam.nasa_planets.core.domain.NetworkError
import com.bagmanovam.nasa_planets.core.domain.Result
import com.bagmanovam.nasa_planets.core.domain.map
import com.bagmanovam.nasa_planets.domain.model.SpaceItem
import com.bagmanovam.nasa_planets.domain.repository.SearchSpaceItemsRepository
import com.bagmanovam.nasa_planets.domain.useCase.GetSpaceItemsUseCase

class GetSpaceItemsInteractor(private val repository: SearchSpaceItemsRepository): GetSpaceItemsUseCase {
    override suspend fun invoke(count: Int): Result<List<SpaceItem>, NetworkError> {
        return repository.getSpaceItems(count)
    }
}