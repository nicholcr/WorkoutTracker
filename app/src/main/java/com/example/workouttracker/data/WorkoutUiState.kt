package com.example.workouttracker.data

import java.util.Date

data class WorkoutUiState (
    val name: String = "",
    val dateTime: Date,
    val durationMinutes: Int = 0,
    val exercises: List<Exercise> = listOf()
)