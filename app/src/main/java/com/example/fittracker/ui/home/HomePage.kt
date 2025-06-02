package com.example.fittracker.ui.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import java.time.*
import java.time.format.TextStyle
import java.util.*


@Composable
fun HomePage(
    onWorkoutPanelButtonClick: () -> Unit = {},
    onDateClick: (LocalDate) -> Unit = {}
) {
    Column(modifier = Modifier.fillMaxSize()) {

        Header(onAddClick = onWorkoutPanelButtonClick)
        FitNotesStyleCalendar(onDateClick = onDateClick)
    }
}

@Composable
fun FitNotesStyleCalendar(
    year: Int = LocalDate.now().year,
    onDateClick: (LocalDate) -> Unit = {
        println("TODO")
    }
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(12) { monthIndex ->
            val month = Month.of(monthIndex + 1)
            val yearMonth = YearMonth.of(year, monthIndex + 1)
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = month.getDisplayName(TextStyle.FULL, Locale.getDefault()) + " $year",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(start = 8.dp, bottom = 4.dp)
                )
                CalendarMonthGrid(yearMonth, onDateClick)
            }
        }
    }
}

@Composable
fun CalendarMonthGrid(
    yearMonth: YearMonth,
    onDateClick: (LocalDate) -> Unit
) {
    val firstDayOfMonth = yearMonth.atDay(1)
    val daysInMonth = yearMonth.lengthOfMonth()
    val firstDayOfWeek = firstDayOfMonth.dayOfWeek.value % 7 // Monday = 1 ... Sunday = 7 => %7 => Monday = 1, Sunday = 0
    val totalCells = daysInMonth + firstDayOfWeek

    Column {
        DaysOfWeekHeader()
        LazyVerticalGrid(
            columns = GridCells.Fixed(7),
            modifier = Modifier
                .fillMaxWidth()
                .height(((totalCells / 7 + 1) * 40).dp),
            userScrollEnabled = false
        ) {
            items(totalCells) { index ->
                if (index < firstDayOfWeek) {
                    Box(modifier = Modifier.size(40.dp)) {} // Empty box before the 1st
                } else {
                    val day = index - firstDayOfWeek + 1
                    val date = yearMonth.atDay(day)
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .padding(2.dp)
                            .clickable { onDateClick(date) },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "$day", fontSize = 14.sp)
                    }
                }
            }
        }
    }
}

@Composable
fun DaysOfWeekHeader() {
    val daysOfWeek = listOf("Pon", "Wt", "Śr", "Czw", "Pt", "Sob", "Ndz")
    Row(modifier = Modifier.fillMaxWidth()) {
        for (day in daysOfWeek) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(30.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(text = day, fontSize = 12.sp, fontWeight = FontWeight.Medium)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Header(
    onAddClick: () -> Unit = {}
)
// custom header with Title and Button that
// open WorkoutPanel
{
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(75.dp)
            .background(Color(0xFF2C2C2C))
            .padding(top = 16.dp)
            .padding(horizontal = 16.dp)

    ) {
        Text(
            text = "Fit Tracker",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterStart)
        )

        IconButton(
            onClick = onAddClick,
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .size(48.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Przejdz do zakladni Workout Panel",
                tint = Color.LightGray,
                modifier = Modifier
                    .size(34.dp)

            )
        }
    }
}




