package com.example.workouttracker.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface WorkoutRoutineDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(workoutRoutine: WorkoutRoutine)

    @Update
    suspend fun update(workoutRoutine: WorkoutRoutine)

    @Delete
    suspend fun delete(workoutRoutine: WorkoutRoutine)

    @Query("SELECT * from workoutroutine WHERE id = :id")
    fun getWorkoutRoutine(id: Int): Flow<WorkoutRoutine>

    @Query("SELECT * from workoutroutine ORDER BY name ASC")
    fun getAllWorkoutRoutines(): Flow<List<WorkoutRoutine>>

    @Query("SELECT * FROM workoutroutine WHERE id = :id")
    suspend fun getWorkoutRoutineById(id: Int): WorkoutRoutine?

    @Query("SELECT * FROM workoutroutine WHERE name LIKE :searchQuery ORDER BY name ASC")
    fun searchWorkoutRoutines(searchQuery: String): Flow<List<WorkoutRoutine>>
}