package com.bagmanovam.nasa_planets.domain.interactor

import com.bagmanovam.nasa_planets.domain.model.SpaceItem
import com.bagmanovam.nasa_planets.domain.repository.SpaceItemsDbRepository
import com.bagmanovam.nasa_planets.domain.useCase.GetSpaceItemsDbUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class GetSpaceItemsDbInteractor(private val repository: SpaceItemsDbRepository) : GetSpaceItemsDbUseCase {
    override suspend fun invoke(): Flow<List<SpaceItem>> {
        return withContext(Dispatchers.IO) { repository.getAllSpaceItems() }
    }
}