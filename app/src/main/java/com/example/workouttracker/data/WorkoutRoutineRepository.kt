package com.example.workouttracker.data

import kotlinx.coroutines.flow.Flow

/**
 * Repository that provides insert, update, delete, and retrieve of [WorkoutRoutine] from a given data source.
 */
interface WorkoutRoutineRepository {
    fun getAllWorkoutRoutinesStream(): Flow<List<WorkoutRoutine>>
    fun getWorkoutRoutineStream(id: Int): Flow<WorkoutRoutine?>

    suspend fun insertWorkoutRoutine(workoutRoutine: WorkoutRoutine)
    suspend fun updateWorkoutRoutine(workoutRoutine: WorkoutRoutine)
    suspend fun deleteWorkoutroutine(workoutRoutine: WorkoutRoutine)
}