package com.asantivanezg.paginationexercise.data.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.asantivanezg.paginationexercise.data.db.MovieDatabase
import com.asantivanezg.paginationexercise.data.db.entity.MovieEntity
import com.asantivanezg.paginationexercise.data.db.entity.MovieKey
import com.asantivanezg.paginationexercise.data.mapper.asListModel
import com.asantivanezg.paginationexercise.data.remote.api_service.ApiService

@OptIn(ExperimentalPagingApi::class)
class MovieMediator(
    private val apiService: ApiService,
    private val movieDb: MovieDatabase
) : RemoteMediator<Int, MovieEntity>() {

    private val moviesDao = movieDb.movieDao()
    private val moviesKeyDao = movieDb.movieKeyDao()

    override suspend fun load(loadType: LoadType, state: PagingState<Int, MovieEntity>): MediatorResult {
        return try {
            val currentPage = when (loadType) {
                LoadType.REFRESH -> {
                    val remoteKeys = getRemoteKeysClosestToCurrentPosition(state)
                    remoteKeys?.nextPage?.minus(1) ?: 1
                }

                LoadType.PREPEND -> {
                    val remoteKeys = getRemoteKeysForFirstItem(state)
                    val prevPage = remoteKeys?.prevPage ?: return MediatorResult.Success(
                        endOfPaginationReached = remoteKeys != null
                    )
                    prevPage
                }

                LoadType.APPEND -> {
                    val remoteKeys = getRemoteKeysForLastItem(state)
                    val nextPage = remoteKeys?.nextPage ?: return MediatorResult.Success(
                        endOfPaginationReached = remoteKeys != null
                    )
                    nextPage
                }
            }

            val response = apiService.getUpcomingMovies(lang = "es", page = currentPage)
            val endOfPaginationReached = response.totalPages == currentPage

            val prevPage = if (currentPage == 1) null else currentPage - 1
            val nextPage = if (endOfPaginationReached) null else currentPage + 1

            movieDb.withTransaction {

                if (loadType == LoadType.REFRESH) {
                    moviesDao.deleteMovies()
                    moviesKeyDao.deleteAllMovieKey()
                }

                moviesDao.addMovies(response.results.asListModel())
                val keys = response.results.map { movie ->
                    MovieKey(
                        id = movie.id.toString(),
                        prevPage = prevPage,
                        nextPage = nextPage
                    )
                }
                moviesKeyDao.addAllMovieKeys(movieKeys = keys)
            }
            MediatorResult.Success(endOfPaginationReached)

        } catch (e: Exception) {
            MediatorResult.Error(e)
        }
    }

    private suspend fun getRemoteKeysClosestToCurrentPosition(
        state: PagingState<Int, MovieEntity>
    ): MovieKey? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?._id?.let { id ->
                moviesKeyDao.getMovieKeys(id = id)
            }
        }
    }

    private suspend fun getRemoteKeysForFirstItem(
        state: PagingState<Int, MovieEntity>
    ): MovieKey? {
        return state.pages.firstOrNull() { it.data.isNotEmpty() }?.data?.firstOrNull()?.let { movie ->
            moviesKeyDao.getMovieKeys(movie._id)
        }
    }

    private suspend fun getRemoteKeysForLastItem(
        state: PagingState<Int, MovieEntity>
    ): MovieKey? {
        return state.pages.lastOrNull { it.data.isNotEmpty() }?.data?.lastOrNull()?.let { movie ->
            moviesKeyDao.getMovieKeys(movie._id)
        }
    }

}