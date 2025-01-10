package com.example.workouttracker.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(entities = [WorkoutRoutine::class, PastWorkout::class], version = 1, exportSchema = false)
abstract class WorkoutRoutineDatabase : RoomDatabase() {

    abstract fun workoutRoutineDao(): WorkoutRoutineDao
    abstract fun pastWorkoutDao(): PastWorkoutDao

    companion object {
        @Volatile
        private var instance: WorkoutRoutineDatabase? = null

        @OptIn(InternalCoroutinesApi::class)
        fun getDatabase(context: Context): WorkoutRoutineDatabase {
            return instance ?: synchronized(this) {
                Room.databaseBuilder(context, WorkoutRoutineDatabase::class.java, "workout_routine_database")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { instance = it }
            }
        }
    }
}