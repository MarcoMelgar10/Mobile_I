package com.example.practico_3.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.practico_3.data.model.Trip
import com.example.practico_3.ui.viewmodel.TripViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTripsScreen(
    viewModel: TripViewModel,
    onNavigateBack: () -> Unit,
    onNavigateToCreateTrip: () -> Unit,
    onTripClick: (Trip) -> Unit
) {
    val myTrips by viewModel.myTrips.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val error by viewModel.error.collectAsState()
    val currentUsername by viewModel.currentUsername.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadMyTrips()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Viajes de $currentUsername") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Volver")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onNavigateToCreateTrip) {
                Icon(Icons.Default.Add, contentDescription = "Crear viaje")
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            when {
                isLoading -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }
                error != null -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Error: $error")
                    }
                }
                myTrips.isEmpty() -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("No tienes viajes creados")
                    }
                }
                else -> {
                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(myTrips) { trip ->
                            TripItem(
                                trip = trip,
                                currentUsername = currentUsername,
                                onClick = { onTripClick(trip) }
                            )
                        }
                    }
                }
            }
        }
    }
}
