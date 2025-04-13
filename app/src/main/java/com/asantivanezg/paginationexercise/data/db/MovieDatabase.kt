package com.asantivanezg.paginationexercise.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.asantivanezg.paginationexercise.data.db.dao.MovieDao
import com.asantivanezg.paginationexercise.data.db.dao.MovieKeyDao
import com.asantivanezg.paginationexercise.data.db.entity.MovieEntity
import com.asantivanezg.paginationexercise.data.db.entity.MovieKey

@Database(entities = [MovieEntity::class, MovieKey::class], version = 1)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao() : MovieDao
    abstract fun movieKeyDao() : MovieKeyDao
}