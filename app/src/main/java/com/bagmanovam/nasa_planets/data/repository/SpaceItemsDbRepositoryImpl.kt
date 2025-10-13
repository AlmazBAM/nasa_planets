package com.bagmanovam.nasa_planets.data.repository

import com.bagmanovam.nasa_planets.data.db.SpaceItemDao
import com.bagmanovam.nasa_planets.data.mapper.entitiesToDomains
import com.bagmanovam.nasa_planets.data.mapper.entityToDomain
import com.bagmanovam.nasa_planets.data.mapper.toEntities
import com.bagmanovam.nasa_planets.domain.model.SpaceItem
import com.bagmanovam.nasa_planets.domain.repository.SpaceItemsDbRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SpaceItemsDbRepositoryImpl(private val dao: SpaceItemDao) : SpaceItemsDbRepository {
    override suspend fun getAllSpaceItems(): Flow<List<SpaceItem>> {
        return dao.getSpaceItems().map { it.entitiesToDomains() }
    }

    override suspend fun getSpaceItem(noteId: Int): SpaceItem {
        return dao.getSpaceItem(noteId).entityToDomain()
    }

    override suspend fun saveAllSpaceItems(items: List<SpaceItem>) {
        dao.addSpaceItems(items.toEntities())
    }
}