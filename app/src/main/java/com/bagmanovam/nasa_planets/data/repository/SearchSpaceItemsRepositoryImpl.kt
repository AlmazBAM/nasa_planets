package com.bagmanovam.nasa_planets.data.repository

import android.util.Log
import com.bagmanovam.nasa_planets.core.domain.NetworkError
import com.bagmanovam.nasa_planets.core.domain.Result
import com.bagmanovam.nasa_planets.data.internet.NasaApi
import com.bagmanovam.nasa_planets.data.mapper.toDomains
import com.bagmanovam.nasa_planets.domain.model.SpaceItem
import com.bagmanovam.nasa_planets.domain.repository.SearchSpaceItemsRepository
import kotlinx.coroutines.ensureActive
import kotlinx.serialization.SerializationException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.nio.channels.UnresolvedAddressException
import kotlin.coroutines.coroutineContext

class SearchSpaceItemsRepositoryImpl(private val api: NasaApi) : SearchSpaceItemsRepository {
    override suspend fun getSpaceItems(count: Int): Result<List<SpaceItem>, NetworkError> {
        return try {
            val response = api.getSpaceObjects(count)
            Log.i(TAG, "getSpaceObjects: $response")
            when (response.code()) {
                in 200..299 -> {
                    try {
                        val bd = response.body()
                        if (bd != null)
                            Result.Success(bd.toDomains())
                        else
                            Result.Error(NetworkError.SERVER_ERROR)
                    } catch (_: Exception) {
                        Result.Error(NetworkError.SERVER_ERROR)
                    }
                }

                408 -> Result.Error(NetworkError.REQUEST_TIMEOUT)
                429 -> Result.Error(NetworkError.TOO_MANY_REQUESTS)
                in 500..599 -> Result.Error(NetworkError.SERVER_ERROR)
                else -> {
                    Result.Error(NetworkError.UNKNOWN)
                }
            }
        } catch (_: UnresolvedAddressException) {
            return Result.Error(NetworkError.NO_INTERNET)
        } catch (_: UnknownHostException) {
            return Result.Error(NetworkError.NO_INTERNET)
        } catch (_: SocketTimeoutException) {
            return Result.Error(NetworkError.REQUEST_TIMEOUT)
        } catch (_: SerializationException) {
            return Result.Error(NetworkError.SERIALIZATION)
        } catch (_: ConnectException) {
            return Result.Error(NetworkError.CONNECTION_ERROR)
        } catch (_: Exception) {
            coroutineContext.ensureActive()
            return Result.Error(NetworkError.UNKNOWN)
        }
    }

    companion object {
        private val TAG = SearchSpaceItemsRepositoryImpl::class.java.simpleName
    }
}