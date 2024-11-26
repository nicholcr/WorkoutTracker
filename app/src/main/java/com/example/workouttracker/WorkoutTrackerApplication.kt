package com.example.workouttracker

import android.app.Application
import com.example.workouttracker.data.AppContainer
import com.example.workouttracker.data.AppDataContainer

class WorkoutTrackerApplication : Application() {

    /**
     * AppContainer instance used by the rest of classes to obtain dependencies
     */
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}