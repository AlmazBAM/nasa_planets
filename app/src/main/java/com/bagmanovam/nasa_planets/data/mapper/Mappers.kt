package com.bagmanovam.nasa_planets.data.mapper

import com.bagmanovam.nasa_planets.data.db.SpaceItemEntity
import com.bagmanovam.nasa_planets.data.model.SpaceItemDto
import com.bagmanovam.nasa_planets.domain.model.SpaceItem


fun SpaceItemDto.toDomain(): SpaceItem {
    return SpaceItem(
        date = this.date ?: "",
        explanation = this.explanation ?: "",
        hdUrl = this.hdUrl ?: "",
        mediaType = this.mediaType ?: "",
        serviceVersion = this.serviceVersion ?: "",
        title = this.title ?: "",
        url = this.url ?: ""
    )
}

fun SpaceItemEntity.entityToDomain(): SpaceItem {
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


fun List<SpaceItem>.toEntities(): List<SpaceItemEntity> {
    return this.map {
        SpaceItemEntity(
            id = 0,
            date = it.date,
            explanation = it.explanation,
            hdUrl = it.hdUrl,
            mediaType = it.mediaType,
            serviceVersion = it.serviceVersion,
            title = it.title,
            url = it.url
        )
    }
}

fun List<SpaceItemEntity>.entitiesToDomains(): List<SpaceItem> {
    return this.map {
        SpaceItem(
            date = it.date,
            explanation = it.explanation,
            hdUrl = it.hdUrl,
            mediaType = it.mediaType,
            serviceVersion = it.serviceVersion,
            title = it.title,
            url = it.url
        )
    }
}