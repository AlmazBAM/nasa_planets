package com.bagmanovam.nasa_planets.presentation.home.model

import com.bagmanovam.nasa_planets.domain.model.SpaceItem

data class SpaceItemUi(
    val date: String?,
    val explanation: String?,
    val hdUrl: String?,
    val mediaType: String?,
    val serviceVersion: String?,
    val title: String?,
    val url: String?,
)

fun SpaceItem.toUi(): SpaceItemUi {
    return SpaceItemUi(
        date = this.date,
        explanation = this.explanation,
        hdUrl = this.hdUrl,
        mediaType = this.mediaType,
        serviceVersion = this.serviceVersion,
        title = this.title,
        url = this.url
    )
}


