package com.bagmanovam.nasa_planets.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface SpaceItemDao {

    @Insert(SpaceItemEntity::class, REPLACE)
    fun addSpaceItems(items: List<SpaceItemEntity>)

    @Query("SELECT * FROM space_items")
    fun getSpaceItems(): Flow<List<SpaceItemEntity>>
}