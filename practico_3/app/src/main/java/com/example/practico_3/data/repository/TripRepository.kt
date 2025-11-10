package com.example.practico_3.data.repository

import com.example.practico_3.data.model.Place
import com.example.practico_3.data.model.Trip
import com.example.practico_3.data.remote.RetrofitInstance

class TripRepository {

    private val api = RetrofitInstance.api


    suspend fun getAllTrips(): Result<List<Trip>> {
        return try {
            val trips = api.getAllTrips()
            Result.success(trips)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getTripsByUsername(username: String): Result<List<Trip>> {
        return try {
            val trips = api.getTripsByUsername(username)
            Result.success(trips)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun createTrip(trip: Trip): Result<Trip> {
        return try {
            val createdTrip = api.createTrip(trip)
            Result.success(createdTrip)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    // Place operations
    suspend fun getPlacesByTrip(tripId: Int): Result<List<Place>> {
        return try {
            val places = api.getPlacesByTrip(tripId)
            Result.success(places)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun createPlace(place: Place): Result<Place> {
        return try {
            val createdPlace = api.createPlace(place)
            Result.success(createdPlace)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
