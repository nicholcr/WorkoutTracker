package com.example.workouttracker.data

import kotlinx.coroutines.flow.Flow

/**
 * Repository that provides insert, update, delete, and retrieve of [WorkoutRoutine] from a given data source.
 */
interface WorkoutRoutineRepository {
    fun getAllWorkoutRoutinesStream(): Flow<List<WorkoutRoutine>>
    fun getWorkoutRoutineStream(id: Int): Flow<WorkoutRoutine?>
    fun searchWorkoutRoutines(searchQuery: String): Flow<List<WorkoutRoutine>>

    suspend fun insertWorkoutRoutine(workoutRoutine: WorkoutRoutine)
    suspend fun updateWorkoutRoutine(workoutRoutine: WorkoutRoutine)
    suspend fun deleteWorkoutRoutine(workoutRoutine: WorkoutRoutine)
    suspend fun getWorkoutRoutineById(id: Int): WorkoutRoutine?
}