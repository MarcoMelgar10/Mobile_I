package com.example.practico_3.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practico_3.ui.viewmodel.SplashViewModel

@Composable
fun SplashScreen(
    viewModel: SplashViewModel,
    onNavigateToAllTrips: (String) -> Unit
) {
    val username by viewModel.username.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Organizador de Viajes",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 48.dp)
        )

        Text(
            text = "Usuario:",
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = username,
            onValueChange = { viewModel.updateUsername(it) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            singleLine = true
        )

        Button(
            onClick = {
                if (viewModel.isUsernameValid()) {
                    onNavigateToAllTrips(username)
                }
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = viewModel.isUsernameValid()
        ) {
            Text("Ingresar")
        }
    }
}
