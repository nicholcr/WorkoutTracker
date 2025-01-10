package com.example.workouttracker.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PastWorkout(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val date: Long, // store date/time as a timestamp
    val workoutRoutineId: Int, // foreign key to a WorkoutRoutine
    val exerciseData: List<ExerciseData>
)
