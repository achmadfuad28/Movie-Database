package com.achmadfuad.data.room

import androidx.room.TypeConverter
import com.achmadfuad.data.model.room_entity.MovieDetailEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MovieDetailConverter {

        @TypeConverter
        fun fromString(value: String): List<MovieDetailEntity> {
            val listType = object : TypeToken<List<MovieDetailEntity>>(){}.type
            return Gson().fromJson(value, listType)
        }

        @TypeConverter
        fun fromStoryDetail(movieChild: List<MovieDetailEntity>?): String {
            return Gson().toJson(movieChild)
        }
}
