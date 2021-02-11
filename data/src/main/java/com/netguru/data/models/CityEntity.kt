package com.netguru.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CityEntity(
    @PrimaryKey val created: Long,
    @ColumnInfo val name: String,
    @ColumnInfo val color: String
)