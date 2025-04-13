package com.asantivanezg.paginationexercise.data.mapper

import com.asantivanezg.paginationexercise.data.db.entity.MovieEntity
import com.asantivanezg.paginationexercise.data.remote.entity.MovieNetwork

fun MovieNetwork.asModel(): MovieEntity {
    return MovieEntity(
        _id = this.id.toString(),
        voteAverage = this.voteAverage,
        releaseDate = this.releaseDate,
        posterPath = this.posterPath,
        title = this.title,
        overview = this.overview
    )
}

fun List<MovieNetwork>.asListModel(): List<MovieEntity> = this.map { it.asModel() }