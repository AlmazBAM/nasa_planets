package com.bagmanovam.nasa_planets.domain.mapper

import com.bagmanovam.nasa_planets.data.model.SpaceItemDto
import com.bagmanovam.nasa_planets.domain.model.SpaceItem


fun SpaceItemDto.toDomain(): SpaceItem {
    return SpaceItem(
        date = this.date,
        explanation = this.explanation,
        hdUrl = this.hdUrl,
        mediaType = this.mediaType,
        serviceVersion = this.serviceVersion,
        title = this.title,
        url = this.url
    )
}

fun List<SpaceItemDto>.toDomains(): List<SpaceItem> {
    return this.map { it.toDomain() }
}