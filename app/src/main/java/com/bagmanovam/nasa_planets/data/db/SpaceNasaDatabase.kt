package com.bagmanovam.nasa_planets.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        SpaceItemEntity::class
    ], version = 1, exportSchema = false
)
abstract class SpaceNasaDatabase : RoomDatabase() {
    abstract fun getDao(): SpaceItemDao
}