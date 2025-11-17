package com.tuapp.MakerRouter.data.remote

import com.tuapp.MakerRouter.data.remote.dto.PointDto
import com.tuapp.MakerRouter.data.remote.dto.PointRequest
import com.tuapp.MakerRouter.data.remote.dto.RouteRequest
import com.tuapp.MakerRouter.data.remote.dto.RouteResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface RoutesApi {

    @GET("routes/{username}")
    suspend fun getRoutesByUser(
        @Path("username") username: String
    ): List<RouteResponse>

    @POST("routes")
    suspend fun createRoute(
        @Body request: RouteRequest
    ): RouteResponse

    @PUT("routes/{id}")
    suspend fun updateRoute(
        @Path("id") routeId: String,
        @Body request: RouteRequest
    ): RouteResponse

    @DELETE("routes/{id}")
    suspend fun deleteRoute(
        @Path("id") routeId: String
    ): Response<Unit>


    @GET("routes/{id}/locations")
    suspend fun getPointsByRoute(
        @Path("id") routeId: String
    ): List<PointDto>

    @POST("locations")
    suspend fun createPoint(
        @Body request: PointRequest
    ): PointDto

    @DELETE("locations/{id}")
    suspend fun deletePoint(
        @Path("id") pointId: String
    ): Response<Unit>

}