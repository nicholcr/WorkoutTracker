package com.example.workouttracker.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.internal.synchronized

@Database(entities = [WorkoutRoutine::class], version = 1, exportSchema = false)
abstract class WorkoutRoutineDatabase : RoomDatabase() {

    abstract fun workoutRoutineDao(): WorkoutRoutineDao

    companion object {
        @Volatile
        private var Instance: WorkoutRoutineDatabase? = null

        fun getDatabase(context: Context): WorkoutRoutineDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, WorkoutRoutineDatabase::class.java, "workout_routine_database")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}