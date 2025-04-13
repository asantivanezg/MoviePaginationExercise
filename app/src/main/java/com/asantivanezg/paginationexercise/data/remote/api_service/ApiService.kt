package com.asantivanezg.paginationexercise.data.remote.api_service

import com.asantivanezg.paginationexercise.data.remote.response.GetUpcomingMoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/3/movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("language") lang: String,
        @Query("page") page: Int,
    ): GetUpcomingMoviesResponse
}