package com.example.workouttracker.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface PastWorkoutDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(pastWorkout: PastWorkout)

    @Update
    suspend fun update(pastWorkout: PastWorkout)

    @Delete
    suspend fun delete(pastWorkout: PastWorkout)

    @Query("SELECT * FROM pastworkout WHERE id = :id")
    fun getPastWorkout(id: Int): Flow<PastWorkout>

    @Query("SELECT * FROM pastworkout ORDER BY date DESC")
    fun getAllPastWorkouts(): Flow<List<PastWorkout>>

    @Query("SELECT * FROM pastworkout WHERE workoutRoutineId = :routineId ORDER BY date DESC")
    fun getPastWorkoutsByRoutine(routineId: Int): Flow<List<PastWorkout>>
}
