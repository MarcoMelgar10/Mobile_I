package com.example.practico_3.data.remote

import com.example.practico_3.data.model.Place
import com.example.practico_3.data.model.Trip
import retrofit2.http.*

interface ApiService {


    @GET("api/trips")
    suspend fun getAllTrips(): List<Trip>

    @GET("api/trips/{username}")
    suspend fun getTripsByUsername(@Path("username") username: String): List<Trip>

    @POST("api/trips")
    suspend fun createTrip(@Body trip: Trip): Trip

    @PUT("api/trips/{id}")
    suspend fun updateTrip(@Path("id") id: Int, @Body trip: Trip): Trip

    @DELETE("api/trips/{id}")
    suspend fun deleteTrip(@Path("id") id: Int)


    @GET("api/places")
    suspend fun getAllPlaces(): List<Place>

    @GET("api/trips/{tripId}/places")
    suspend fun getPlacesByTrip(@Path("tripId") tripId: Int): List<Place>

    @POST("api/places")
    suspend fun createPlace(@Body place: Place): Place

    @PUT("api/places/{id}")
    suspend fun updatePlace(@Path("id") id: Int, @Body place: Place): Place

    @DELETE("api/places/{id}")
    suspend fun deletePlace(@Path("id") id: Int)
}
