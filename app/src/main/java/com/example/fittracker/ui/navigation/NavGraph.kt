
package com.example.fittracker.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.fittracker.ui.home.HomePage
import com.example.fittracker.ui.panel.WorkoutPanel

sealed class Routes(val route: String) {
    object Home : Routes("home")
    object Workout : Routes("workout")
}

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Routes.Home.route) {
        composable(Routes.Home.route) {
            HomePage(onWorkoutPanelButtonClick = {
                // after clicking button in header "+", open Workout Panel
                navController.navigate(Routes.Workout.route)
            })
        }
        composable(Routes.Workout.route) {
            WorkoutPanel()
        }
    }
}