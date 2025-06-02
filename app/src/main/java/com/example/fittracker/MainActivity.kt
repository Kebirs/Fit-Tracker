package com.example.fittracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.fittracker.ui.navigation.AppNavigation
import com.example.fittracker.ui.theme.FitTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FitTrackerTheme {
                val navController = rememberNavController()
                Surface(color = MaterialTheme.colorScheme.background) {
                    AppNavigation(navController)
                }
            }
        }
    }
}

//@Composable
//fun AppNavigation(navController: NavHostController) {
//    NavHost(navController = navController, startDestination = "home") {
//        composable("home") {
//            HomePage(
//                onWorkoutPanelButtonClick = {
//                    navController.navigate("workouts")
//                },
//                onDateClick = { selectedDate ->
//                    println("Kliknięto: $selectedDate")
//                }
//            )
//        }
//        composable("workouts") {
//            WorkoutPanel()
//        }
//    }
//}

