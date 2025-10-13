package com.bagmanovam.nasa_planets.domain.repository

import com.bagmanovam.nasa_planets.domain.model.SpaceItem
import kotlinx.coroutines.flow.Flow

interface SpaceItemsDbRepository {

    suspend fun getAllSpaceItems(): Flow<List<SpaceItem>>
    suspend fun saveAllSpaceItems(items: List<SpaceItem>)
}