package com.example.workouttracker.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.workouttracker.data.PastWorkout
import com.example.workouttracker.data.PastWorkoutRepository
import kotlinx.coroutines.launch

class PastWorkoutViewModel(private val pastWorkoutRepository: PastWorkoutRepository) : ViewModel() {

    val allPastWorkouts: LiveData<List<PastWorkout>> =
        pastWorkoutRepository.getAllPastWorkoutsStream().asLiveData()

    fun getPastWorkout(id: Int): LiveData<PastWorkout?> =
        pastWorkoutRepository.getPastWorkoutStream(id).asLiveData()

    fun getPastWorkoutsByRoutine(routineId: Int): LiveData<List<PastWorkout>> =
        pastWorkoutRepository.getPastWorkoutsByRoutineStream(routineId).asLiveData()

    fun insertPastWorkout(pastWorkout: PastWorkout) = viewModelScope.launch {
        pastWorkoutRepository.insertPastWorkout(pastWorkout)
    }

    fun updatePastWorkout(pastWorkout: PastWorkout) = viewModelScope.launch {
        pastWorkoutRepository.updatePastWorkout(pastWorkout)
    }

    fun deletePastWorkout(pastWorkout: PastWorkout) = viewModelScope.launch {
        pastWorkoutRepository.deletePastWorkout(pastWorkout)
    }
}
