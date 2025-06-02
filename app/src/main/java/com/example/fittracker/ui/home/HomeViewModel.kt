package com.example.fittracker.ui.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.time.LocalDate

class HomeViewModel : ViewModel() {

    // Kliknięta data z kalendarza
    private val _selectedDate = MutableStateFlow<LocalDate?>(null)
    val selectedDate: StateFlow<LocalDate?> = _selectedDate

    // Lista treningów — przykładowo
    private val _workouts = MutableStateFlow<List<String>>(emptyList())
    val workouts: StateFlow<List<String>> = _workouts

    fun onDateClicked(date: LocalDate) {
        _selectedDate.value = date

        // TODO: Ładowanie dane z bazy/pamięci, np. treningi tego dnia
        _workouts.value = listOf("Przysiady", "Pompki", "Bieganie")
    }
}
