package com.tuapp.MakerRouter.data.remote.dto

import com.google.gson.annotations.SerializedName

data class PointRequest(
    val latitude: String,
    val longitude: String,
    @SerializedName("route_id") val routeId: Int
)