package com.example.fittracker.ui.panel

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.fittracker.ui.components.AddWorkoutButton

@Composable
fun WorkoutPanel(viewModel: WorkoutViewModel = viewModel()) {
    Scaffold(
        floatingActionButton = {
            AddWorkoutButton(onClick = viewModel::addWorkout)
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            // Dodaj tutaj zawartość panelu
        }
    }
}


