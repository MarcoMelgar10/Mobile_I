package com.tuapp.MakerRouter.domain.repository

import com.google.android.gms.maps.model.LatLng
import com.tuapp.MakerRouter.domain.model.Route
import kotlinx.coroutines.flow.Flow

interface RoutesRepository {

    fun getRoutes(username: String): Flow<List<Route>>
    suspend fun createRoute(name: String, username: String): Route?
    suspend fun updateRoute(routeId: String, name: String, username: String)
    suspend fun deleteRoute(routeId: String)

    fun getPoints(routeId: String): Flow<List<LatLng>>
    suspend fun savePoints(routeId: Int, points: List<LatLng>)
}