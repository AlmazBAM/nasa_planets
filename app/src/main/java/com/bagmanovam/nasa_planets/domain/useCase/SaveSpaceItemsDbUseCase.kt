package com.bagmanovam.nasa_planets.domain.useCase

import com.bagmanovam.nasa_planets.domain.model.SpaceItem

interface SaveSpaceItemsDbUseCase {
    suspend operator fun invoke(items: List<SpaceItem>)
}