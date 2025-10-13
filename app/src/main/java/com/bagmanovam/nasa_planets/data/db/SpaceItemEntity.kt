package com.bagmanovam.nasa_planets.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("space_items")
data class SpaceItemEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val date: String,
    val explanation: String,
    @ColumnInfo("hd_url")
    val hdUrl: String,
    @ColumnInfo("media_type")
    val mediaType: String,
    @ColumnInfo("service_version")
    val serviceVersion: String,
    val title: String,
    val url: String,
)