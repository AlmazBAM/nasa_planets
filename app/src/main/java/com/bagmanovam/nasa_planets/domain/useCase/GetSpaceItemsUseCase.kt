package com.bagmanovam.nasa_planets.domain.useCase

import com.bagmanovam.nasa_planets.core.domain.NetworkError
import com.bagmanovam.nasa_planets.core.domain.Result
import com.bagmanovam.nasa_planets.domain.model.SpaceItem

interface GetSpaceItemsUseCase {
    suspend operator fun invoke(count: Int): Result<List<SpaceItem>, NetworkError>
}