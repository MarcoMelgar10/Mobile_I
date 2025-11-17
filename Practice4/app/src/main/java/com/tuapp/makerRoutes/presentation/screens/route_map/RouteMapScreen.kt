
package com.tuapp.MakerRouter.presentation.screens.route_map

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import com.tuapp.MakerRouter.presentation.components.CustomButton

@Composable
fun RouteMapScreen(
    viewModel: RouteMapViewModel = hiltViewModel(),
    username: String,
    routeId: String,
    routeName: String,
    onSaveComplete: () -> Unit
) {
    val routePoints by viewModel.routePoints.collectAsState()

    var isPointerRed by remember { mutableStateOf(false) }
    var isDeleteMode by remember { mutableStateOf(false) }

    val santaCruzLocation = LatLng(-17.7785, -63.1822)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(santaCruzLocation, 15f)
    }

    Scaffold(
        bottomBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp, vertical = 24.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    CustomButton(
                        text = if (isDeleteMode) "Cancel Delete" else "Add point",
                        onClick = {
                            if (isDeleteMode) {
                                isDeleteMode = false
                            } else {
                                val centerPosition = cameraPositionState.position.target
                                viewModel.onMapClick(centerPosition)
                                isPointerRed = true
                                viewModel.onAddPointClick()
                                isPointerRed = false
                            }
                        },
                        enabled = true,
                        modifier = Modifier.weight(1f)
                    )

                    Spacer(modifier = Modifier.width(16.dp))

                    CustomButton(
                        text = "Save and exit",
                        onClick = {
                            viewModel.saveRoute(onSaveComplete)
                        },
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        },
        floatingActionButton = {
            if (routePoints.isNotEmpty()) {
                FloatingActionButton(
                    onClick = { isDeleteMode = !isDeleteMode },
                    containerColor = if (isDeleteMode) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(bottom = 80.dp)
                ) {
                    Icon(
                        imageVector = if (isDeleteMode) Icons.Default.Add else Icons.Default.Delete,
                        contentDescription = if (isDeleteMode) "Exit Delete Mode" else "Delete Mode"
                    )
                }
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            GoogleMap(
                modifier = Modifier.fillMaxSize(),
                cameraPositionState = cameraPositionState,
                uiSettings = MapUiSettings(zoomControlsEnabled = true),
                onMapClick = { }
            ) {
                routePoints.forEachIndexed { index, point ->
                    Marker(
                        state = MarkerState(position = point),
                        title = if (isDeleteMode) "Tap to delete" else "point ${index + 1}",
                        snippet = if (isDeleteMode) "Click here to remove this point" else null,
                        icon = BitmapDescriptorFactory.defaultMarker(
                            if (isDeleteMode) BitmapDescriptorFactory.HUE_ORANGE
                            else BitmapDescriptorFactory.HUE_RED
                        ),
                        onClick = {
                            if (isDeleteMode) {
                                viewModel.onDeletePointClick(point)
                                true
                            } else {
                                it.showInfoWindow()
                                false
                            }
                        }
                    )
                }
            }

            if (!isDeleteMode) {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = "Location Pointer",
                    tint = if (isPointerRed) Color.Red else Color(0xFF0288D1),
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(48.dp)
                        .offset(y = (-24).dp)
                )
            }
        }
    }
}