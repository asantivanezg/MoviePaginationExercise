package com.asantivanezg.paginationexercise.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie")
data class MovieEntity(
    @PrimaryKey(autoGenerate = false)
    val _id: String,
    val voteAverage: Double,
    val releaseDate: String,
    val posterPath: String,
    val title: String,
    val overview: String
)
