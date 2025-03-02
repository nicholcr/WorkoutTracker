package com.example.workouttracker.workout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workouttracker.R
import com.example.workouttracker.WorkoutTopAppBar
import com.example.workouttracker.data.Exercise
import com.example.workouttracker.ui.AppViewModelProvider
import com.example.workouttracker.ui.navigation.NavigationDestination
import kotlinx.coroutines.launch

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
    val coroutineScope = rememberCoroutineScope()

    Scaffold (
        topBar = {
            WorkoutTopAppBar(
                title = stringResource(AddWorkoutRoutineDestination.titleRes),
                canNavigateBack = canNavigateBack,
                navigateUp = onNavigateUp
            )
        }
    ) { innerPadding ->
        AddWorkoutRoutineBody(
            workoutRoutineUiState = viewModel.workoutRoutineUiState,
            onValueChange = viewModel::updateUiState,
            onSaveClick = {
                coroutineScope.launch {
                    viewModel.saveWorkoutRoutine()
                    navigateBack()
                }
            },
            modifier = Modifier
                .padding(
                    start = innerPadding.calculateStartPadding(LocalLayoutDirection.current),
                    end = innerPadding.calculateEndPadding(LocalLayoutDirection.current),
                    top = innerPadding.calculateTopPadding()
                )
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()
        )
    }
}

@Composable
fun AddWorkoutRoutineBody(
    workoutRoutineUiState: WorkoutRoutineUiState,
    onValueChange: (WorkoutRoutineDetails) -> Unit,
    onSaveClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium))
    ) {
        OutlinedTextField(
            value = workoutRoutineUiState.workoutRoutineDetails.name,
            onValueChange = { onValueChange(workoutRoutineUiState.workoutRoutineDetails.copy(name = it)) },
            label = { Text(stringResource(R.string.workout_routine_name_req)) },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )
        ExerciseList(
            exercises = workoutRoutineUiState.workoutRoutineDetails.exerciseList,

        )
    }
}

@Composable
private fun ExerciseList(
    exercises: List<Exercise>,
    onExerciseChange: (Exercise) -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    LazyColumn(
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
        modifier = modifier.padding(top = dimensionResource(R.dimen.padding_medium))
    ) {
        items(exercises, key = { exercise -> exercise.name }) { exercise ->
            ExerciseListItem(
                exercise = exercise,
                onExerciseChange = onExerciseChange
            )
        }
    }
}

@Composable
fun ExerciseListItem(
    exercise: Exercise,
    onExerciseChange: (Exercise) -> Unit,
    modifier: Modifier = Modifier
) {
    Card (
        elevation = CardDefaults.cardElevation(),
        modifier = modifier,
        shape = RoundedCornerShape(R.dimen.card_corner_radius)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    vertical = dimensionResource(R.dimen.padding_small),
                    horizontal = dimensionResource(R.dimen.padding_medium)
                )
        ) {
            OutlinedTextField(
                value = exercise.name,
                onValueChange = { onExerciseChange(exercise.copy(name = it)) },
                label = { Text("Exercise Name") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = exercise.sets,
                onValueChange = { onExerciseChange(exercise.copy(sets = it)) },
                label = { Text("Number of Sets") },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}