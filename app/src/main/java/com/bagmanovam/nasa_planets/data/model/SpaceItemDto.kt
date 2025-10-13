package com.bagmanovam.nasa_planets.data.model

import com.google.gson.annotations.SerializedName


data class SpaceItemDto(
    @SerializedName("date") val date: String?,
    @SerializedName("explanation") val explanation: String?,
    @SerializedName("hdUrl") val hdUrl: String?,
    @SerializedName("mediaType") val mediaType: String?,
    @SerializedName("serviceVersion") val serviceVersion: String?,
    @SerializedName("title") val title: String?,
    @SerializedName("url") val url: String?,
)