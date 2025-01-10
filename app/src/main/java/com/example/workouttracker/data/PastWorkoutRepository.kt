package com.example.workouttracker.data

import kotlinx.coroutines.flow.Flow

interface PastWorkoutRepository {
    fun getAllPastWorkoutsStream(): Flow<List<PastWorkout>>
    fun getPastWorkoutStream(id: Int): Flow<PastWorkout?>
    fun getPastWorkoutsByRoutineStream(routineId: Int): Flow<List<PastWorkout>>

    suspend fun insertPastWorkout(pastWorkout: PastWorkout)
    suspend fun updatePastWorkout(pastWorkout: PastWorkout)
    suspend fun deletePastWorkout(pastWorkout: PastWorkout)
}
