package com.bagmanovam.nasa_planets.domain.repository

import com.bagmanovam.nasa_planets.core.domain.NetworkError
import com.bagmanovam.nasa_planets.core.domain.Result
import com.bagmanovam.nasa_planets.data.model.SpaceItemDto
import com.bagmanovam.nasa_planets.domain.model.SpaceItem

interface SearchSpaceItemsRepository {
    suspend fun getSpaceItems(count: Int): Result<List<SpaceItem>, NetworkError>
}