package com.example.workouttracker.data

import androidx.room.TypeConverter

class Converters {
    @TypeConverter
    fun fromExerciseDataList(value: List<ExerciseData>): String {
        return Gson().toJson(value) // Convert list to JSON string
    }

    @TypeConverter
    fun toExerciseDataList(value: String): List<ExerciseData> {
        val type = object : TypeToken<List<ExerciseData>>() {}.type
        return Gson().fromJson(value, type)
    }
}
