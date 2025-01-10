package com.example.workouttracker.workout

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.workouttracker.data.Exercise
import com.example.workouttracker.data.WorkoutRoutine
import com.example.workouttracker.data.WorkoutRoutineRepository

/**
 * ViewModel to validate and insert workout routines in the Room database.
 */
class AddWorkoutRoutineViewModel(private val workoutRoutineRepository: WorkoutRoutineRepository) : ViewModel() {

    /**
     * Holds current workout routine ui state
     */
    var workoutRoutineUiState by mutableStateOf(WorkoutRoutineUiState())
        private set

    /**
     * Updates the [workoutRoutineUiState] with the value provided in the argument. This method also triggers
     * a validation for input values.
     */
    fun updateUiState(workoutRoutineDetails: WorkoutRoutineDetails) {
        workoutRoutineUiState =
            WorkoutRoutineUiState(workoutRoutineDetails = workoutRoutineDetails, isEntryValid = validateInput(workoutRoutineDetails))
    }

    private fun validateInput(uiState : WorkoutRoutineDetails = workoutRoutineUiState.workoutRoutineDetails) : Boolean {
        return with(uiState) {
            name.isNotBlank() && exerciseList.isNotEmpty()
        }
    }

    suspend fun saveWorkoutRoutine() {
        if (validateInput()) {
            workoutRoutineRepository.insertWorkoutRoutine(workoutRoutineUiState.workoutRoutineDetails.toWorkoutRoutine())
        }
    }
}

/**
 * Represents Ui State for a workout routine.
 */
data class WorkoutRoutineUiState(
    val workoutRoutineDetails: WorkoutRoutineDetails = WorkoutRoutineDetails(),
    val isEntryValid: Boolean = false
)

data class WorkoutRoutineDetails(
    val id: Int = 0,
    val name: String = "",
    val exerciseList: List<Exercise> = listOf()
)

fun WorkoutRoutineDetails.toWorkoutRoutine(): WorkoutRoutine = WorkoutRoutine(
    id = id,
    name = name,
    exerciseList = exerciseList
)