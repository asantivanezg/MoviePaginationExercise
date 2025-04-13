package com.asantivanezg.paginationexercise.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.asantivanezg.paginationexercise.data.db.entity.MovieKey

@Dao
interface MovieKeyDao {

    @Query("SELECT * FROM MovieKey where id=:id")
    suspend fun getMovieKeys(id: String): MovieKey

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllMovieKeys(movieKeys: List<MovieKey>)

    @Query("DELETE FROM MovieKey")
    suspend fun deleteAllMovieKey()

}