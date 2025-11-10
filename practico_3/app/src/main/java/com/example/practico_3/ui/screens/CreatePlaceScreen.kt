package com.example.practico_3.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.practico_3.ui.viewmodel.TripViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreatePlaceScreen(
    viewModel: TripViewModel,
    tripId: Int,
    onNavigateBack: () -> Unit
) {
    var name by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var imageUrl by remember { mutableStateOf("") }
    var directions by remember { mutableStateOf("") }
    var timeToSpend by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }

    val isLoading by viewModel.isLoading.collectAsState()
    val error by viewModel.error.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Lugar:") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Regresar")
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
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Nombre *") },
                modifier = Modifier.fillMaxWidth(),
                enabled = !isLoading
            )

            OutlinedTextField(
                value = city,
                onValueChange = { city = it },
                label = { Text("Ciudad *") },
                modifier = Modifier.fillMaxWidth(),
                enabled = !isLoading
            )

            OutlinedTextField(
                value = description,
                onValueChange = { description = it },
                label = { Text("Descripción") },
                modifier = Modifier.fillMaxWidth(),
                minLines = 3,
                enabled = !isLoading
            )

            OutlinedTextField(
                value = imageUrl,
                onValueChange = { imageUrl = it },
                label = { Text("URL de la imagen") },
                modifier = Modifier.fillMaxWidth(),
                enabled = !isLoading
            )

            OutlinedTextField(
                value = directions,
                onValueChange = { directions = it },
                label = { Text("Indicaciones de cómo llegar") },
                modifier = Modifier.fillMaxWidth(),
                minLines = 2,
                enabled = !isLoading
            )

            OutlinedTextField(
                value = timeToSpend,
                onValueChange = { timeToSpend = it },
                label = { Text("Tiempo estimado de permanencia") },
                modifier = Modifier.fillMaxWidth(),
                enabled = !isLoading,
                placeholder = { Text("Ej: 2 horas, 1 día") }
            )

            OutlinedTextField(
                value = price,
                onValueChange = { price = it },
                label = { Text("Precio") },
                modifier = Modifier.fillMaxWidth(),
                enabled = !isLoading,
                placeholder = { Text("Ej: $50 por persona") }
            )

            if (error != null) {
                Text(
                    text = "Error: $error",
                    color = MaterialTheme.colorScheme.error
                )
            }

            Button(
                onClick = {
                    if (name.isNotBlank() && city.isNotBlank()) {
                        viewModel.createPlace(
                            tripId = tripId,
                            name = name,
                            city = city,
                            description = description,
                            imageUrl = imageUrl,
                            directions = directions,
                            timeToSpend = timeToSpend,
                            price = price,
                            onSuccess = { onNavigateBack() }
                        )
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                enabled = name.isNotBlank() && city.isNotBlank() && !isLoading
            ) {
                if (isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(20.dp),
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                } else {
                    Text("Agregar Lugar")
                }
            }

            Text(
                text = "Los * son Campos obligatorios",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
