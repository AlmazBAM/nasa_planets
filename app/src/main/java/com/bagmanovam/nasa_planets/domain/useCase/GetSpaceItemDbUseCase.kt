package com.bagmanovam.nasa_planets.domain.useCase

import com.bagmanovam.nasa_planets.domain.model.SpaceItem
import kotlinx.coroutines.flow.Flow

interface GetSpaceItemDbUseCase {
   suspend operator fun invoke(itemId: Int): SpaceItem
}