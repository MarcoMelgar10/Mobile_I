package com.example.practico_3.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.practico_3.ui.viewmodel.TripViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlaceDetailScreen(
    viewModel: TripViewModel,
    onNavigateBack: () -> Unit
) {
    val selectedPlace by viewModel.selectedPlace.collectAsState()

    selectedPlace?.let { place ->
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(place.name) },
                    navigationIcon = {
                        IconButton(onClick = onNavigateBack) {
                            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Volver")
                        }
                    }
                )
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                if (place.imageUrl != null) {
                    AsyncImage(
                        model = place.imageUrl,
                        contentDescription = place.name,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(250.dp),
                        contentScale = ContentScale.Crop
                    )
                }

                Text(
                    text = place.name,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )

                DetailRow(label = "Ciudad", value = place.city)

                if (!place.description.isNullOrBlank()) {
                    Column {
                        Text(
                            text = "Descripción",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = place.description,
                            fontSize = 14.sp,
                            modifier = Modifier.padding(top = 4.dp)
                        )
                    }
                }
                if (!place.directions.isNullOrBlank()) {
                    Column {
                        Text(
                            text = "Indicaciones",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = place.directions,
                            fontSize = 14.sp,
                            modifier = Modifier.padding(top = 4.dp)
                        )
                    }
                }

                if (!place.timeToSpend.isNullOrBlank()) {
                    DetailRow(label = "Tiempo permanencia", value = place.timeToSpend)
                }
                if (!place.price.isNullOrBlank()) {
                    DetailRow(label = "Precio", value = place.price)
                }
            }
        }
    }
}

@Composable
fun DetailRow(label: String, value: String) {
    Column {
        Text(
            text = label,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = value,
            fontSize = 14.sp,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}
