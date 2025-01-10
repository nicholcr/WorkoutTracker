package com.example.workouttracker.data

data class ExerciseData(
    val exerciseName: String, // matches exercise ID from the workout routine
    val weightsUsed: List<Double> // weight for each set
)
