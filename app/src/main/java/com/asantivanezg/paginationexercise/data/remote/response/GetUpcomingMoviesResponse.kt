package com.asantivanezg.paginationexercise.data.remote.response

import com.asantivanezg.paginationexercise.data.remote.model.MovieNetwork
import com.google.gson.annotations.SerializedName

data class GetUpcomingMoviesResponse(

    @SerializedName("page")
    val page: Int,

    @SerializedName("results")
    val results: List<MovieNetwork>,

    @SerializedName("total_pages")
    val totalPages: Int,

    @SerializedName("total_results")
    val totalResults: Int,
)