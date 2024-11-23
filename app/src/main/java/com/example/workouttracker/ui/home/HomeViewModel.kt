package com.example.workouttracker.ui.home

import androidx.lifecycle.ViewModel
import com.example.workouttracker.data.WorkoutRoutine

/**
 * ViewModel to retrieve all items in the Room database.
 */
class HomeViewModel : ViewModel() {
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}

/**
 * Ui State for WorkoutHomeScreen
 */
data class WorkoutHomeUiState(val workoutRoutineList: List<WorkoutRoutine> = listOf())