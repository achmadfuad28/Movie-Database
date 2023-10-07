package com.achmadfuad.data.model.room_entity

import androidx.room.*

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(movie: MovieDetailEntity)
    @Query("SELECT * from movie_detail_entity")
    fun getAllMovie(): List<MovieDetailEntity>
}