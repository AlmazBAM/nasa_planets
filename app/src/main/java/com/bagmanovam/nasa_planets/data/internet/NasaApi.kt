package com.bagmanovam.nasa_planets.data.internet

import com.bagmanovam.nasa_planets.data.model.SpaceItemDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NasaApi {

    @GET("apod")
    suspend fun getSpaceObjects(
        @Query("count") count: Int,
    ): Response<List<SpaceItemDto>>
}