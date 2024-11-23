package com.example.workouttracker.workout

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.workouttracker.R
import com.example.workouttracker.data.WorkoutRoutine
import com.example.workouttracker.ui.navigation.NavigationDestination

object WorkoutRoutineDetailsDestination: NavigationDestination {
    override val route = "workout_routine_details"
    override val titleRes = R.string.workout_routine_details_title
    const val workoutRoutineIdArg = "workoutRoutineId"
    val routeWithArgs = "$route/{$workoutRoutineIdArg}"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WorkoutRoutineDetailsScreen(
    navigateToEditWorkoutRoutine: (Int) -> Unit,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
}