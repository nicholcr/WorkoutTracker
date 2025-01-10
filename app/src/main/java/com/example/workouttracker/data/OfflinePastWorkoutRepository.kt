package com.example.workouttracker.data

import kotlinx.coroutines.flow.Flow

class OfflinePastWorkoutRepository(private val pastWorkoutDao: PastWorkoutDao) : PastWorkoutRepository {

    override fun getAllPastWorkoutsStream(): Flow<List<PastWorkout>> = pastWorkoutDao.getAllPastWorkouts()

    override fun getPastWorkoutStream(id: Int): Flow<PastWorkout?> = pastWorkoutDao.getPastWorkout(id)

    override fun getPastWorkoutsByRoutineStream(routineId: Int): Flow<List<PastWorkout>> =
        pastWorkoutDao.getPastWorkoutsByRoutine(routineId)

    override suspend fun insertPastWorkout(pastWorkout: PastWorkout) = pastWorkoutDao.insert(pastWorkout)

    override suspend fun updatePastWorkout(pastWorkout: PastWorkout) = pastWorkoutDao.update(pastWorkout)

    override suspend fun deletePastWorkout(pastWorkout: PastWorkout) = pastWorkoutDao.delete(pastWorkout)
}
