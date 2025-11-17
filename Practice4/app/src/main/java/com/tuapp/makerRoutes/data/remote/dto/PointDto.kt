package com.tuapp.MakerRouter.data.remote.dto

import com.google.android.gms.maps.model.LatLng
import com.google.gson.annotations.SerializedName

data class PointDto(
    val id: Int,
    val latitude: String,
    val longitude: String,
    @SerializedName("route_id") val routeId: Int
) {
    fun toDomainModel(): LatLng {
        return LatLng(
            latitude.toDouble(),
            longitude.toDouble()
        )
    }
}