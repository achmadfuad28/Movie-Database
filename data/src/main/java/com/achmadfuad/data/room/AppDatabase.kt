package com.achmadfuad.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.achmadfuad.data.model.room_entity.MovieDao
import com.achmadfuad.data.model.room_entity.MovieDetailEntity

@Database(entities = [MovieDetailEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

    companion object {
        fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "appdatabase.db"
            ).allowMainThreadQueries()
                .build()
    }
}
