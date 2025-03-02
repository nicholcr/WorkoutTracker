package com.example.workouttracker.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import com.example.workouttracker.ui.home.WorkoutHomeDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.workouttracker.ui.home.WorkoutHomeScreen
import com.example.workouttracker.workout.AddWorkoutRoutineDestination
import com.example.workouttracker.workout.AddWorkoutRoutineScreen
import com.example.workouttracker.workout.EditWorkoutRoutineDestination
import com.example.workouttracker.workout.EditWorkoutRoutineScreen
import com.example.workouttracker.workout.WorkoutRoutineDetailsDestination
import com.example.workouttracker.workout.WorkoutRoutineDetailsScreen
import com.example.workouttracker.workout.WorkoutRoutineListDestination
import com.example.workouttracker.workout.WorkoutRoutineListScreen

@Composable
fun WorkoutNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = WorkoutHomeDestination.route,
        modifier = modifier
    ) {
        composable(route = WorkoutHomeDestination.route) {
            WorkoutHomeScreen(
                navigateToWorkoutRoutineList = { navController.navigate(AddWorkoutRoutineDestination.route) },
                navigateToRoutineUpdate = { navController.navigate("${WorkoutRoutineDetailsDestination.route}/${it}") }
            )
        }
        composable(route = WorkoutRoutineListDestination.route) {
            WorkoutRoutineListScreen(
                navigateToAddRoutine = { navController.navigate(AddWorkoutRoutineDestination.route) },
            )
        }
        composable(route = AddWorkoutRoutineDestination.route) {
            AddWorkoutRoutineScreen(
                navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() }
            )
        }
        composable(
            route = WorkoutRoutineDetailsDestination.routeWithArgs,
            arguments = listOf(navArgument(WorkoutRoutineDetailsDestination.workoutRoutineIdArg){
                type = NavType.IntType
            })
        ) {
            WorkoutRoutineDetailsScreen(
                navigateToEditWorkoutRoutine = { navController.navigate("${EditWorkoutRoutineDestination.route}/$it") },
                navigateBack = { navController.navigateUp() }
            )
        }
        composable(
            route = EditWorkoutRoutineDestination.routeWithArgs,
            arguments = listOf(navArgument(EditWorkoutRoutineDestination.workoutRoutineIdArg) {
                type = NavType.IntType
            })
        ) {
            EditWorkoutRoutineScreen(
                navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() }
            )
        }
    }
}