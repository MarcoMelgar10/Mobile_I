package com.tuapp.MakerRouter.data.remote.repository

import com.google.android.gms.maps.model.LatLng
import com.tuapp.MakerRouter.data.remote.RoutesApi
import com.tuapp.MakerRouter.data.remote.dto.PointRequest
import com.tuapp.MakerRouter.data.remote.dto.RouteRequest
import com.tuapp.MakerRouter.domain.model.Route
import com.tuapp.MakerRouter.domain.repository.RoutesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RoutesRepositoryImpl @Inject constructor(
    private val api: RoutesApi
) : RoutesRepository {

    override fun getRoutes(username: String): Flow<List<Route>> = flow {
        while (true) {
            try {
                val dtoList = api.getRoutesByUser(username)
                emit(dtoList.map { it.toDomainModel() })
            } catch (e: Exception) {
                e.printStackTrace()
                emit(emptyList())
            }
            delay(2000)
        }
    }.flowOn(Dispatchers.IO)

    override suspend fun createRoute(name: String, username: String): Route? = withContext(Dispatchers.IO) {
        try {
            val request = RouteRequest(name = name, username = username)
            api.createRoute(request).toDomainModel()
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    override suspend fun updateRoute(routeId: String, name: String, username: String) {
        withContext(Dispatchers.IO) {
            try {
                val request = RouteRequest(name = name, username = username)
                api.updateRoute(routeId, request)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override suspend fun deleteRoute(routeId: String) {
        withContext(Dispatchers.IO) {
            try {
                api.deleteRoute(routeId)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun getPoints(routeId: String): Flow<List<LatLng>> = flow {
        try {
            val dtoList = api.getPointsByRoute(routeId)
            emit(dtoList.map { it.toDomainModel() })
        } catch (e: Exception) {
            e.printStackTrace()
            emit(emptyList())
        }
    }.flowOn(Dispatchers.IO)

    override suspend fun savePoints(routeId: Int, points: List<LatLng>) = withContext(Dispatchers.IO) {
        try {
            points.forEach { latLng ->
                val request = PointRequest(
                    latitude = latLng.latitude.toString(),
                    longitude = latLng.longitude.toString(),
                    routeId = routeId
                )
                api.createPoint(request)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}