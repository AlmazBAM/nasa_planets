package com.bagmanovam.nasa_planets.domain.interactor

import com.bagmanovam.nasa_planets.core.domain.NetworkError
import com.bagmanovam.nasa_planets.core.domain.Result
import com.bagmanovam.nasa_planets.core.domain.map
import com.bagmanovam.nasa_planets.domain.model.SpaceItem
import com.bagmanovam.nasa_planets.domain.repository.SearchSpaceItemsRepository
import com.bagmanovam.nasa_planets.domain.useCase.GetSpaceItemsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetSpaceItemsInteractor(private val repository: SearchSpaceItemsRepository) :
    GetSpaceItemsUseCase {
    override suspend fun invoke(count: Int): Result<List<SpaceItem>, NetworkError> {
        return withContext(Dispatchers.IO) {
            when (val result = repository.getSpaceItems(count)) {
                is Result.Error -> result
                is Result.Success -> {
                    val filtered = result.data.filter { it.mediaType == "jpg" }
                    Result.Success(filtered)
                }
            }
        }
    }
}