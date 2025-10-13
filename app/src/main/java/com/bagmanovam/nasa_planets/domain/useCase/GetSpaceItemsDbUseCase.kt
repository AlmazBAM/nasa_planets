package com.bagmanovam.nasa_planets.domain.useCase

import com.bagmanovam.nasa_planets.domain.model.SpaceItem
import kotlinx.coroutines.flow.Flow

interface GetSpaceItemsDbUseCase {
   suspend operator fun invoke(): Flow<List<SpaceItem>>
}