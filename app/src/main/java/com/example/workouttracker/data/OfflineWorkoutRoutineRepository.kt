package com.example.workouttracker.data

import kotlinx.coroutines.flow.Flow

class OfflineWorkoutRoutineRepository(private val workoutRoutineDao: WorkoutRoutineDao) : WorkoutRoutineRepository {

    override fun getAllWorkoutRoutinesStream(): Flow<List<WorkoutRoutine>> = workoutRoutineDao.getAllWorkoutRoutines()
    override fun getWorkoutRoutineStream(id: Int): Flow<WorkoutRoutine?> = workoutRoutineDao.getWorkoutRoutine(id)

    override suspend fun insertWorkoutRoutine(workoutRoutine: WorkoutRoutine) = workoutRoutineDao.insert(workoutRoutine)
    override suspend fun updateWorkoutRoutine(workoutRoutine: WorkoutRoutine) = workoutRoutineDao.update(workoutRoutine)
    override suspend fun deleteWorkoutRoutine(workoutRoutine: WorkoutRoutine) = workoutRoutineDao.delete(workoutRoutine)
}