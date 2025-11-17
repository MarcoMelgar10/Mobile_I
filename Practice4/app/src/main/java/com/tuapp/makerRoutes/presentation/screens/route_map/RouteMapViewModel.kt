
package com.tuapp.MakerRouter.presentation.screens.route_map

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.maps.model.LatLng
import com.tuapp.MakerRouter.domain.repository.RoutesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RouteMapViewModel @Inject constructor(
    private val repository: RoutesRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val routeId: String = savedStateHandle.get<String>("routeId") ?: ""
    private val routeName: String = savedStateHandle.get<String>("routeName") ?: ""

    private val _tempPoint = MutableStateFlow<LatLng?>(null)
    val tempPoint: StateFlow<LatLng?> = _tempPoint.asStateFlow()

    private val _routePoints = MutableStateFlow<List<LatLng>>(emptyList())
    val routePoints: StateFlow<List<LatLng>> = _routePoints.asStateFlow()

    init {
        loadPoints()
    }

    private fun loadPoints() {
        viewModelScope.launch {
            repository.getPoints(routeId).collect { points ->
                _routePoints.value = points
            }
        }
    }

    fun onMapClick(latLng: LatLng) {
        _tempPoint.value = latLng
    }

    fun onAddPointClick() {
        _tempPoint.value?.let { point ->
            _routePoints.value = _routePoints.value + point
            _tempPoint.value = null
        }
    }

    fun onDeletePointClick(point: LatLng) {
        _routePoints.value = _routePoints.value.filter { it != point }
    }

    fun saveRoute(onComplete: () -> Unit) {
        viewModelScope.launch {
            try {
                val routeIdInt = routeId.toIntOrNull() ?: return@launch
                repository.savePoints(routeIdInt, _routePoints.value)
                onComplete()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
