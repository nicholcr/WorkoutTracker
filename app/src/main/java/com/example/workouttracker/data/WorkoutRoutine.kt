package com.example.workouttracker.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WorkoutRoutine(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val exercises: List<Exercise>
)
