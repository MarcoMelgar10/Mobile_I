package com.example.practico_3.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practico_3.data.model.Place
import com.example.practico_3.data.model.Trip
import com.example.practico_3.data.repository.TripRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TripViewModel : ViewModel() {

    private val repository = TripRepository()

    private val _trips = MutableStateFlow<List<Trip>>(emptyList())
    val trips: StateFlow<List<Trip>> = _trips.asStateFlow()

    private val _myTrips = MutableStateFlow<List<Trip>>(emptyList())
    val myTrips: StateFlow<List<Trip>> = _myTrips.asStateFlow()

    private val _places = MutableStateFlow<List<Place>>(emptyList())
    val places: StateFlow<List<Place>> = _places.asStateFlow()

    private val _selectedPlace = MutableStateFlow<Place?>(null)
    val selectedPlace: StateFlow<Place?> = _selectedPlace.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    private val _currentUsername = MutableStateFlow("")
    val currentUsername: StateFlow<String> = _currentUsername.asStateFlow()

    fun setCurrentUsername(username: String) {
        _currentUsername.value = username
    }

    fun loadAllTrips() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            repository.getAllTrips().fold(
                onSuccess = { tripList ->
                    _trips.value = tripList
                    _isLoading.value = false
                },
                onFailure = { exception ->
                    _error.value = exception.message
                    _isLoading.value = false
                }
            )
        }
    }

    fun loadMyTrips() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            repository.getTripsByUsername(_currentUsername.value).fold(
                onSuccess = { tripList ->
                    _myTrips.value = tripList
                    _isLoading.value = false
                },
                onFailure = { exception ->
                    _error.value = exception.message
                    _isLoading.value = false
                }
            )
        }
    }

    fun loadPlaces(tripId: Int) {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            repository.getPlacesByTrip(tripId).fold(
                onSuccess = { placeList ->
                    _places.value = placeList
                    _isLoading.value = false
                },
                onFailure = { exception ->
                    _error.value = exception.message
                    _isLoading.value = false
                }
            )
        }
    }

    fun selectPlace(place: Place) {
        _selectedPlace.value = place
    }

    fun createTrip(name: String, country: String, onSuccess: () -> Unit) {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            val trip = Trip(name = name, username = _currentUsername.value, country = country)
            repository.createTrip(trip).fold(
                onSuccess = {
                    _isLoading.value = false
                    loadMyTrips()
                    onSuccess()
                },
                onFailure = { exception ->
                    _error.value = exception.message
                    _isLoading.value = false
                }
            )
        }
    }

    fun createPlace(
        tripId: Int,
        name: String,
        city: String,
        description: String?,
        imageUrl: String?,
        directions: String?,
        timeToSpend: String?,
        price: String?,
        onSuccess: () -> Unit
    ) {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            val place = Place(
                name = name,
                city = city,
                tripId = tripId,
                description = description?.ifBlank { null },
                imageUrl = imageUrl?.ifBlank { null },
                directions = directions?.ifBlank { null },
                timeToSpend = timeToSpend?.ifBlank { null },
                price = price?.ifBlank { null }
            )
            repository.createPlace(place).fold(
                onSuccess = {
                    _isLoading.value = false
                    loadPlaces(tripId)
                    onSuccess()
                },
                onFailure = { exception ->
                    _error.value = exception.message
                    _isLoading.value = false
                }
            )
        }
    }
}
