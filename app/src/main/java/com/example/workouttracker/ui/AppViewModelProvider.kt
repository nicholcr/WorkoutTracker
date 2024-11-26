package com.example.workouttracker.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.workouttracker.ui.home.HomeViewModel
import com.example.workouttracker.WorkoutTrackerApplication
import com.example.workouttracker.workout.AddWorkoutRoutineViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {

        initializer {
            AddWorkoutRoutineViewModel()
        }

        initializer {
            HomeViewModel()
        }
    }
}

fun CreationExtras.workoutTrackerApplication() : WorkoutTrackerApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as WorkoutTrackerApplication)