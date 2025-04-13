package com.asantivanezg.paginationexercise.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MovieKey(
    @PrimaryKey(autoGenerate = false)
    val id : String,

    val prevPage : Int?,
    val nextPage : Int?
)
