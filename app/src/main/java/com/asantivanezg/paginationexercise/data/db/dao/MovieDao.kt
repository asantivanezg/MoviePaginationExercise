package com.asantivanezg.paginationexercise.data.db.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.asantivanezg.paginationexercise.data.db.entity.MovieEntity

@Dao
interface MovieDao {
    @Query("SELECT * FROM movie")
    fun getMovies() : PagingSource<Int, MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMovies(quotes : List<MovieEntity>)

    @Query("DELETE FROM movie")
    suspend fun deleteMovies()

}