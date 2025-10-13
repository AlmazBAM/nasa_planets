package com.bagmanovam.nasa_planets

import com.bagmanovam.nasa_planets.domain.model.SpaceObject
import kotlinx.serialization.Serializable

@Serializable
object Home

@Serializable
data class Description(val itemId: Int)