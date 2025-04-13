package com.asantivanezg.paginationexercise.data.remote.model

import com.google.gson.annotations.SerializedName

data class MovieNetwork(

    @SerializedName("id")
    val id : Int,

    @SerializedName("vote_average")
    val voteAverage: Double,

    @SerializedName("release_date")
    val releaseDate: String,

    @SerializedName("poster_path")
    val posterPath: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("overview")
    val overview: String
)
