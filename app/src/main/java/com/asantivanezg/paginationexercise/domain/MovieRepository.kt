package com.asantivanezg.paginationexercise.domain

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.asantivanezg.paginationexercise.data.db.MovieDatabase
import com.asantivanezg.paginationexercise.data.paging.MovieMediator
import com.asantivanezg.paginationexercise.data.remote.api_service.ApiService
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val api: ApiService,
    private val movieDb: MovieDatabase
) {

    companion object{
        const val MAX_ITEMS = 20
        const val PREFETCH_ITEMS = 3
    }

    @OptIn(ExperimentalPagingApi::class)
    fun getUpcomingMovies() = Pager(
        config = PagingConfig(MAX_ITEMS, PREFETCH_ITEMS),
        remoteMediator = MovieMediator(api, movieDb),
        pagingSourceFactory = { movieDb.movieDao().getMovies() }
    ).flow
}