package com.bagmanovam.nasa_planets.domain.repository

import com.bagmanovam.nasa_planets.core.domain.NetworkError
import com.bagmanovam.nasa_planets.core.domain.Result
import com.bagmanovam.nasa_planets.data.model.SpaceItemDto

interface SearchSpaceItemsRepository {
    suspend fun getSpaceItems(count: Int): Result<List<SpaceItemDto>, NetworkError>
}