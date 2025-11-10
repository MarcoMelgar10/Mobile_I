package com.example.practico_3.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practico_3.data.model.Trip
import com.example.practico_3.ui.viewmodel.TripViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AllTripsScreen(
    viewModel: TripViewModel,
    onNavigateToMyTrips: () -> Unit,
    onNavigateToCreateTrip: () -> Unit,
    onTripClick: (Trip) -> Unit
) {
    val trips by viewModel.trips.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val error by viewModel.error.collectAsState()
    val currentUsername by viewModel.currentUsername.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadAllTrips()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Todos los Viajes") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onNavigateToCreateTrip) {
                Icon(Icons.Default.Add, contentDescription = "Crear viaje")
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Button(
                onClick = onNavigateToMyTrips,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Mis Viajes")
            }

            Spacer(modifier = Modifier.height(16.dp))

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
                trips.isEmpty() -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("No hay viajes disponibles")
                    }
                }
                else -> {
                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(trips) { trip ->
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

@Composable
fun TripItem(
    trip: Trip,
    currentUsername: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = trip.username,
                fontSize = 14.sp,
                color = if (trip.username == currentUsername)
                    MaterialTheme.colorScheme.primary
                else
                    MaterialTheme.colorScheme.onSurfaceVariant
            )
            Text(
                text = trip.name,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 4.dp)
            )
            Text(
                text = trip.country,
                fontSize = 16.sp
            )
        }
    }
}
