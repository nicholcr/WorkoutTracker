package com.example.workouttracker.workout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workouttracker.R
import com.example.workouttracker.WorkoutTopAppBar
import com.example.workouttracker.data.Exercise
import com.example.workouttracker.ui.AppViewModelProvider
import com.example.workouttracker.ui.navigation.NavigationDestination

object AddWorkoutRoutineDestination: NavigationDestination {
    override val route = "add_workout_routine"
    override val titleRes = R.string.add_workout_routine_title
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddWorkoutRoutineScreen(
    addExerciseToWorkoutRoutine: () -> Unit,
    navigateBack: () -> Unit,
    onNavigateUp: () -> Unit,
    canNavigateBack: Boolean = true,
    viewModel: AddWorkoutRoutineViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    Scaffold (
        topBar = {
            WorkoutTopAppBar(
                title = stringResource(AddWorkoutRoutineDestination.titleRes),
                canNavigateBack = canNavigateBack,
                navigateUp = onNavigateUp
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = addExerciseToWorkoutRoutine,
                shape = MaterialTheme.shapes.large,
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_large))
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(R.string.add_exercise_to_routine_title)
                )
            }
        }
    ) { innerPadding ->
        AddWorkoutRoutineBody(

        )
    }
}

@Composable
fun AddWorkoutRoutineBody(
    workoutRoutineUiState: WorkoutRoutineUiState,
    onSaveClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(

    )
}

@Composable
fun ExerciseCard(

)