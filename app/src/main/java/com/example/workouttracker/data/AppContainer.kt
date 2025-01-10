package com.example.workouttracker.data

import android.content.Context

/**
 * App container for Dependency injection.
 */
interface AppContainer {
    val workoutRoutineRepository: WorkoutRoutineRepository
    val pastWorkoutRepository: PastWorkoutRepository
}

/**
 * [AppContainer] implementation that provides instance of [OfflineWorkoutRoutineRepository]
 */
class AppDataContainer(private val context: Context) : AppContainer {
    /**
     * Implementation for [WorkoutRoutineRepository]
     */
    override val workoutRoutineRepository: WorkoutRoutineRepository by lazy {
        OfflineWorkoutRoutineRepository(WorkoutRoutineDatabase.getDatabase(context).workoutRoutineDao())
    }

    override val pastWorkoutRepository: PastWorkoutRepository by lazy {
        OfflinePastWorkoutRepository(WorkoutRoutineDatabase.getDatabase(context).pastWorkoutDao())
    }
}