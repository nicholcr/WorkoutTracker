package com.example.workouttracker.workout

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.workouttracker.R
import com.example.workouttracker.ui.navigation.NavigationDestination

object EditWorkoutRoutineDestination: NavigationDestination {
    override val route = "edit_workout_routine"
    override val titleRes = R.string.add_workout_routine_title
    const val workoutRoutineIdArg = "workoutRoutineId"
    val routeWithArgs = "$route/{$workoutRoutineIdArg}"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditWorkoutRoutineScreen(
    navigateBack: () -> Unit,
    onNavigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
}