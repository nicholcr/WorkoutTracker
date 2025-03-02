package com.example.workouttracker.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.workouttracker.R
import com.example.workouttracker.WorkoutTopAppBar
import com.example.workouttracker.data.Exercise
import com.example.workouttracker.data.ExerciseList
import com.example.workouttracker.data.WorkoutRoutine
import com.example.workouttracker.ui.navigation.NavigationDestination
import com.example.workouttracker.ui.theme.WorkoutTrackerTheme

object WorkoutHomeDestination : NavigationDestination {
    override val route = "home"
    override val titleRes = R.string.app_name
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WorkoutHomeScreen(
    navigateToWorkoutRoutineList: () -> Unit,
    navigateToRoutineUpdate: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            WorkoutTopAppBar(
                title = stringResource(WorkoutHomeDestination.titleRes),
                canNavigateBack = false,
                scrollBehavior = scrollBehavior
            )
        },

        floatingActionButton = {
            FloatingActionButton(
                onClick = navigateToWorkoutRoutineList,
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_large))
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(R.string.add_workout_routine_title)
                )
            }
        }
    ) { innerPadding ->
        WorkoutHomeBody(
            workoutRoutineList = listOf(),
            onWorkoutRoutineClick = navigateToRoutineUpdate,
            modifier = modifier.fillMaxSize(),
            contentPadding = innerPadding,
        )
    }
}

@Composable
private fun WorkoutHomeBody(
    workoutRoutineList: List<WorkoutRoutine>,
    onWorkoutRoutineClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier,
    ) {
        if (workoutRoutineList.isEmpty()) {
            Text(
                text = stringResource(R.string.no_exercises),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(contentPadding)
            )
        } else {
            WorkoutRoutineList(
                workoutRoutineList = workoutRoutineList,
                onWorkoutRoutineClick = { onWorkoutRoutineClick(it.id) },
                contentPadding = contentPadding,
                modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen.padding_small))
            )
        }
    }
}

@Composable
private fun WorkoutRoutineList(
    workoutRoutineList: List<WorkoutRoutine>,
    onWorkoutRoutineClick: (WorkoutRoutine) -> Unit,
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = contentPadding
    ) {
        items(items = workoutRoutineList, key = {it.id}) { routine ->
            WorkoutRoutineItem(workoutRoutine = routine,
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.padding_small))
                    .clickable { onWorkoutRoutineClick(routine) })
        }
    }
}

@Composable
private fun WorkoutRoutineItem(
    workoutRoutine: WorkoutRoutine, modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_large)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small)),
            horizontalAlignment =  Alignment.CenterHorizontally,
        ) {
            Text(
                text = workoutRoutine.name,
                style = MaterialTheme.typography.titleLarge,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WorkoutHomeBodyPreview() {
    val exercise1 = Exercise("Bench Press", 5)
    val exercise2 = Exercise("Overhead Press", 3)
    val exercises = ExerciseList(listOf(exercise1, exercise2))
    WorkoutTrackerTheme {
        WorkoutHomeBody(listOf(
            WorkoutRoutine(1, "Reddit Push A", exercises)
        ), onWorkoutRoutineClick = {})
    }
}

@Preview(showBackground = true)
@Composable
fun WorkoutHomeBodyEmptyListPreview() {
    WorkoutTrackerTheme {
        WorkoutHomeBody(listOf(), onWorkoutRoutineClick = {})
    }
}

@Preview(showBackground = true)
@Composable
fun WorkoutRoutineItemPreview() {
    val exercise1 = Exercise("Bench Press", 5)
    val exercise2 = Exercise("Overhead Press", 3)
    val exercises = ExerciseList(listOf(exercise1, exercise2))
    WorkoutTrackerTheme {
        WorkoutRoutineItem(
            WorkoutRoutine(1, "Reddit Push A", exercises)
        )
    }
}