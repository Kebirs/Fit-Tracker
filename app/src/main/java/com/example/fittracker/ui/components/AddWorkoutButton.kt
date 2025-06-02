package com.example.fittracker.ui.components

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AddWorkoutButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    LargeFloatingActionButton(
        onClick = onClick,
        shape = CircleShape,
        modifier = modifier
    ) {
        Icon(Icons.Filled.Add, contentDescription = "Dodaj trening")
    }
}