package com.example.workouttracker.workout

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workouttracker.R
import com.example.workouttracker.ui.AppViewModelProvider
import com.example.workouttracker.ui.navigation.NavigationDestination

object AddWorkoutRoutineDestination: NavigationDestination {
    override val route = "add_workout_routine"
    override val titleRes = R.string.add_workout_routine_title
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddWorkoutRoutineScreen(
    navigateBack: () -> Unit,
    onNavigateUp: () -> Unit,
    canNavigateBack: Boolean = true,
    viewModel: AddWorkoutRoutineViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    
}